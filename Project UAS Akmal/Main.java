import java.util.*;
import java.io.*;

class Main {
    public void menu() {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t  RESELLER MANAGEMENT SYSTEM");
        System.out.println("\t\t*******************************************");
        System.out.println("\n\nPress 1 : To Add a Reseller's Details");
        System.out.println("Press 2 : To See a Reseller's Details");
        System.out.println("Press 3 : To Remove a Reseller");
        System.out.println("Press 4 : To Update Reseller's Details");
        System.out.println("Press 5 : To Exit the RMS Portal");
    }
}

class Reseller_Add {
    public void createFile() {
        Scanner sc = new Scanner(System.in);
        ResellerDetail reseller = new ResellerDetail();
        reseller.getInfo();
        try {
            File f1 = new File("file" + reseller.reseller_id + ".txt");
            if (f1.createNewFile()) {
                FileWriter myWriter = new FileWriter("file" + reseller.reseller_id + ".txt");
                myWriter.write("Reseller ID:" + reseller.reseller_id + "\n" + "Reseller Name     :" + reseller.name + "\n" +
                        "Contact  :" + reseller.contact + "\n" + "Email Information :" + reseller.email + "\n" +
                        "Position :" + reseller.position);
                myWriter.close();
                System.out.println("\nReseller has been added :)\n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            } else {
                System.out.println("\nReseller already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ResellerDetail {
    String name;
    String email;
    String position;
    String reseller_id;
    String contact;
    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Reseller's name -------: ");
        name = sc.nextLine();
        System.out.print("Enter Reseller's ID ---------: ");
        reseller_id = sc.nextLine();
        System.out.print("Enter Reseller's Email ID ---: ");
        email = sc.nextLine();
        System.out.print("Enter Reseller's Position ---: ");
        position = sc.nextLine();
        System.out.print("Enter Reseller's Contact Info: ");
        contact = sc.nextLine();
    }
}

class Reseller_Show {
    public void viewFile(String s) throws Exception {
        File file = new File("file" + s + ".txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

class Reseller_Remove {
    public void removeFile(String ID) {
        File file = new File("file" + ID + ".txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("\nReseller has been removed Successfully");
            }
        } else {
            System.out.println("\nReseller does not exist :(");
        }
    }
}

class Reseller_Update {
    public void updateFile(String s, String o, String n) throws IOException {
        File file = new File("file" + s + ".txt");
        Scanner sc = new Scanner(file);
        String fileContext = "";
        while (sc.hasNextLine()) {
            fileContext = fileContext + "\n" + sc.nextLine();
        }
        FileWriter myWriter = new FileWriter("file" + s + ".txt");
        fileContext = fileContext.replaceAll(o, n);
        myWriter.write(fileContext);
        myWriter.close();
    }
}

class CodeExit {
    public void out() {
        System.out.println("\n*****************************************");
        System.out.println("$ cat Thank You For Using my Software :) ");
        System.out.println("*****************************************");
        System.exit(0);
    }
}

class ResellerManagementSystem {
    public static void main(String arv[]) {
        System.out.print("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        Reseller_Show epv = new Reseller_Show();
        int i = 0;
        Main obj1 = new Main();
        obj1.menu();
        while (i < 6) {
            System.out.print("\nPlease Enter choice :");
            i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1:
                    Reseller_Add ep = new Reseller_Add();
                    ep.createFile();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                case 2:
                    System.out.print("\nPlease Enter Reseller's ID :");
                    String s = sc.nextLine();
                    try {
                        epv.viewFile(s);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                case 3:
                    System.out.print("\nPlease Enter Reseller's ID :");
                    s = sc.nextLine();
                    Reseller_Remove epr = new Reseller_Remove();
                    epr.removeFile(s);
                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                case 4:
                    System.out.print("\nPlease Enter Reseller's ID :");
                    String I = sc.nextLine();
                    try {
                        epv.viewFile(I);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    Reseller_Update epu = new Reseller_Update();
                    System.out.print("Please Enter the detail you want to Update :");
                    System.out.print("\nFor Example :\n");
                    System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
                    String o = sc.nextLine();
                    System.out.print("Please Enter the Updated Info :");
                    String n = sc.nextLine();
                    try {
                        epu.updateFile(I, o, n);
                        System.out.print("\nPress Enter to Continue...");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        obj1.menu();
                        break;
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                case 5:
                    CodeExit obj = new CodeExit();
                    obj.out();
            }
        }
    }
}
