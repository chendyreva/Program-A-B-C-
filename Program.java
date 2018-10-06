package ru.geekbrains.chendyreva.homework4;

public class Program extends Thread {
    private final Controller monitor;
    private final int count;
    public Program(Object name, int count, Controller monitor) {
        setName((String) name);
        this.monitor = monitor;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for(int i = 0; i < count; i++) {
                try {
                    while(!monitor.getCurrent().equals(getName())) {
                        monitor.wait();
                    }
                    System.out.println(getName());
                    Thread.sleep(100);
                    monitor.move();
                    monitor.notifyAll();
                } catch (Exception e) {
                }

                }
            }
        }
    }

//    public static void main(String args[]) {
//
//        try {
//            char c[] = {'a','b','c'};
//            OutputStream output = new FileOutputStream("file.txt"); // Создание текстового файла
//            for(int i = 0; i < c.length; i++) {
//                output.write(c[i]); // Запись каждого символа в текстовый файл
//            }
//            output.close();
//
//            InputStream input = new FileInputStream("file.txt");
//            int size = input.available();
//
//            for(int j = 0; j < size; j++) {
//                System.out.print((char)input.read() + " "); // Чтение текстового файла посимвольно
//            }
//            input.close();
//        }catch(IOException e) {
//            System.out.print("Exception");
//        }
//    }
//}
//
//
//
