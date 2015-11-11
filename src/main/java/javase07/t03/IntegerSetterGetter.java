package javase07.t03;

import java.util.Random;

import static java.lang.System.out;

class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;
    //new
    volatile private static int queueGet=0;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {

        int action;
        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    //new
                    queueGet++;
                    if(queueGet<4){getIntegersFromResource(); }
                    queueGet--;
                } else {
                    setIntegersIntoResource();
                }
            }
            out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            out.println("Поток " + getName()+ " хочет извлечь число.");
            number = resource.getELement();
            while (number == null) {
                out.println("Поток " + getName()+ " ждет пока очередь заполнится.");
                resource.wait();
                out.println("Поток " + getName() + " возобновил работу.");
                number = resource.getELement();
            }
            out.println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            out.println("Поток " + getName() + " записал число "+ number);
            resource.notify();
        }
    }
}