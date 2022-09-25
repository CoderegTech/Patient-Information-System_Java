
package systemact_danag;

import static java.lang.System.exit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SystemAct_DANAG {

    public static String user_id;
    public static String f_name;
    public static String Un;
    public static String Pw;
    public static String user_level;
    public static String user_status;
    public static String user_lastlog;
    
    
    public static String patient_id;
    public static String name;
    public static String address;
    public static String b_date;
    public static String occupation;
    public static String status;
    public static String medical_history;
    public static String general_health;
    public static String headaches;
    public static String allergies;
    public static String bleeding_gums;
    
    public static int phone_no;
    public static int age;
    public static int heart_bp;
    

    static Scanner sc_int = new Scanner(System.in);
    static Scanner sc_str = new Scanner(System.in);

    // Date and Time
    static LocalDateTime md = LocalDateTime.now();
    static DateTimeFormatter fl = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    static String outputDate = fl.format(md);

    public static void main(String[] args) throws IOException {
        String start = "y";
        System.out.println("======================================");
        System.out.println("|| Company Name: SANTOS DENTAL CLINIC");
        System.out.println("|| System Name: Patient Information System");
        System.out.println("|| Date: january 15, 2020");
        System.out.println("|| Program By: JOHN REYGUN DANAG");
        System.out.println("======================================");
        System.out.print(" Start? (y/n): ");
        start = sc_str.nextLine();

        while (start.equalsIgnoreCase("y")) {
        System.out.print("=========LOGIN HERE==========\n");
        System.out.print(" Username: ");
        String un = sc_str.nextLine();
        System.out.print(" Password: ");
        String pw = sc_str.nextLine();
        if (GetLogin(un, pw)) {
            UpdateAccount(user_id, "Log", "");
            if (!user_status.equals("active")) {
                System.out.println(" Your account has been disabled\n");
                System.out.println(" Please contact your administraitor!");
                return;
            }
            if (user_level.equals("admin")) {
                ADMIN();
            } else {
                USER();
            }
            
        } else {
            System.out.println("\nInvalid, Username and Password! \nPlease try again!");
        }
        }// End---
        

    }

    public static boolean GetLogin(String user, String pass) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("UserSetting.txt"));
        String rec;
        while ((rec = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(rec, "|");
            if (rec.contains(user)) {
                user_id = st.nextToken();
                f_name = st.nextToken();
                Un = st.nextToken();
                Pw = st.nextToken();
                user_level = st.nextToken();
                user_status = st.nextToken();
                user_lastlog = st.nextToken();
            }

        }
        br.close();

        boolean logged = false;

        logged = pass.equals(Pw);
        return logged;
    }
    
        public static void ADMIN() throws IOException {
        String cont = "y";
        String choice;
        System.out.println("=========WELCOME " + f_name.toUpperCase() + "(Admin Account)==========   ");
        while (cont.equalsIgnoreCase("y")) {
            System.out.println("======================================\n");
            System.out.println(" [1] ADD PATIENT RECORD");
            System.out.println(" [2] SHOW PATIENT RECORD");
            System.out.println(" [3] UPDATE PATIENT RECORD");
            System.out.println(" [4] USER SETTING");
            System.out.println(" [5] EXIT PROGRAM\n");
            System.out.println("======================================");
            System.out.print(" Enter your choice: ");
            choice = sc_str.nextLine();

            if (choice.equals("1")) {
                addRecord();
            } else if (choice.equals("2")) {
                showRecord();
            } else if (choice.equals("3")) {
                UpdateRecord();
            } else if (choice.equals("4")) {
                AdminSetting();
            } else if (choice.equals("5")) {
                exit(0);
            } else {
                System.out.println("Invalid Input!");
            }

            System.out.println("======================================");
            System.out.print("Do you want to continue? (y/n): ");
            cont = sc_str.nextLine();

        }
    }
    
//    User control
    public static void USER() throws IOException {
        String cont = "y";
        String choice;
        System.out.println("=====WELCOME " + f_name.toUpperCase() + "(User Account)=====");
        while (cont.equalsIgnoreCase("y")) {
            System.out.println("======================================\n");
            System.out.println(" [1] ADD PATIENT RECORD");
            System.out.println(" [2] SHOW PATIENT RECORD");
            System.out.println(" [3] UPDATE PATIENT RECORD");
            System.out.println(" [4] EXIT PROGRAM\n");
            System.out.println("======================================");
            System.out.print(" Enter your choice: ");
            choice = sc_str.nextLine();

            if (choice.equals("1")) {
                addRecord();
            } else if (choice.equals("2")) {
                showRecord();
            } else if (choice.equals("3")) {
                UpdateRecord();
            } else if (choice.equals("4")) {
                exit(0);
            } else {
                System.out.println("Invalid Input!");
            }

            System.out.println("======================================");
            System.out.print("Do you want to continue? (y/n): ");
            cont = sc_str.nextLine();

        }
    }
    
//    Add patient record
    public static void addRecord() throws IOException {
        System.out.println("==========ADD PATIENT RECORD==========");
        BufferedWriter bw = new BufferedWriter(new FileWriter("PatientRecordData.txt", true));

        System.out.print(" Enter Patient ID: "); patient_id = sc_str.nextLine();
        System.out.println(" Date: " + outputDate);
        System.out.print(" Enter Name: "); name = sc_str.nextLine();
        System.out.print(" Enter Address: "); address = sc_str.nextLine();
        System.out.print(" Enter Phone No.: "); phone_no = (int) sc_int.nextLong();
        System.out.print(" Enter Birth-Date: "); b_date = sc_str.nextLine();
        System.out.print(" Enter Age: "); age = sc_int.nextInt();
        System.out.print(" Enter Occupation: "); occupation = sc_str.nextLine();
        System.out.print(" Enter Status: "); status = sc_str.nextLine();
        System.out.print(" Enter Medical History: "); medical_history = sc_str.nextLine();
        System.out.print(" Enter General Health: "); general_health = sc_str.nextLine();
        System.out.print(" Enter Headaches: "); headaches = sc_str.nextLine();
        System.out.print(" Enter Allergies: "); allergies = sc_str.nextLine();
        System.out.print(" Enter Bleeding Gums: "); bleeding_gums = sc_str.nextLine();
        System.out.print(" Enter Heart-B.P.: "); heart_bp = sc_int.nextInt();

        bw.write(patient_id + "|" + outputDate + "|" + name + "|" + address + "|" + phone_no + 
                "|" + b_date + "|" + age + "|" + occupation + "|" + status + "|" + medical_history + 
                "|" + general_health + "|" + headaches + "|"+ allergies + "|" + bleeding_gums + "|" + heart_bp);
                                          
        bw.flush();
        bw.newLine();
        bw.close();
    }

//    Show patient record
    public static void showRecord() throws IOException {
        System.out.println("======================================");
        System.out.println(" [1] Patient ID [2] All");
        System.out.println("======================================");
        System.out.print(" Enter your choice: ");
        int cho2 = sc_int.nextInt();
        System.out.println("========SHOW PATIENT RECORD========");

        BufferedReader br = new BufferedReader(new FileReader("PatientRecordData.txt"));
        String rec;

        if (cho2 == 1) {
            System.out.print(" Enter Patient ID: ");
            patient_id = sc_str.nextLine();
            System.out.println("=====SHOW RECORD WITH PATIENT ID:[" + patient_id + "]=====\n");
            while ((rec = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(rec, "|");
                if (rec.contains(patient_id)) {
                    patient_id = st.nextToken();
                    String date = outputDate;
                    date = st.nextToken();

                    System.out.println(" Patient ID: " + patient_id);
                    System.out.println(" Date: " + date);
                    System.out.println(" Name: " + st.nextToken());
                    System.out.println(" Address: " + st.nextToken());
                    System.out.println(" Phone No.: " + st.nextToken());
                    System.out.println(" Birth-Date: " + st.nextToken());
                    System.out.println(" Age: " + st.nextToken());
                    System.out.println(" Occupation: " + st.nextToken());
                    System.out.println(" Status: " + st.nextToken());
                    System.out.println(" Medical History: " + st.nextToken());
                    System.out.println(" General Health: " + st.nextToken());
                    System.out.println(" Headaches: " + st.nextToken());
                    System.out.println(" Allergies: " + st.nextToken());
                    System.out.println(" Bleeding Gums: " + st.nextToken());
                    System.out.println(" Heart-B.P.: " + st.nextToken());
                    System.out.println("======================================\n");

                }
            }
        } else if (cho2 == 2) {
            System.out.println("==========ALL PATIENT RECORD==========\n");
            while ((rec = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(rec, "|");
                patient_id = st.nextToken();
                String date = outputDate;
                date = st.nextToken();


                    System.out.println(" Patient ID: " + patient_id);
                    System.out.println(" Date: " + date);
                    System.out.println(" Name: " + st.nextToken());
                    System.out.println(" Address: " + st.nextToken());
                    System.out.println(" Phone No.: " + st.nextToken());
                    System.out.println(" Birth-Date: " + st.nextToken());
                    System.out.println(" Age: " + st.nextToken());
                    System.out.println(" Occupation: " + st.nextToken());
                    System.out.println(" Status: " + st.nextToken());
                    System.out.println(" Medical History: " + st.nextToken());
                    System.out.println(" General Health: " + st.nextToken());
                    System.out.println(" Headaches: " + st.nextToken());
                    System.out.println(" Allergies: " + st.nextToken());
                    System.out.println(" Bleeding Gums: " + st.nextToken());
                    System.out.println(" Heart-B.P.: " + st.nextToken());
                    System.out.println("======================================\n");

            }
        }
        br.close();

    }

//    Update Patient Record
      public static void UpdateRecord() throws IOException{ 
        System.out.println("========UPDATE PATIENT RECORD========");
        String rec, rec2;
                File TempDB = new File("tempdb1.txt");
                File DB = new File("PatientRecordData.txt");
                
         BufferedReader br = new BufferedReader(new FileReader(DB));
         BufferedWriter bw = new BufferedWriter(new FileWriter(TempDB));
         
         System.out.print(" Enter the Patient ID: "); patient_id = sc_str.nextLine();
         System.out.println("======================================\n");
         
               while( (rec = br.readLine()) != null) {
                      StringTokenizer st = new StringTokenizer(rec, "|");
                      if(rec.contains(patient_id)) {
                            patient_id = st.nextToken();
                            String date = outputDate;
                            date = st.nextToken();

                            System.out.println(" Patient ID: " + patient_id);
                            System.out.println(" Date: " + date);
                            System.out.println(" Name: " + st.nextToken());
                            System.out.println(" Address: " + st.nextToken());
                            System.out.println(" Phone No.: " + st.nextToken());
                            System.out.println(" Birth-Date: " + st.nextToken());
                            System.out.println(" Age: " + st.nextToken());
                            System.out.println(" Occupation: " + st.nextToken());
                            System.out.println(" Status: " + st.nextToken());
                            System.out.println(" Medical History: " + st.nextToken());
                            System.out.println(" General Health: " + st.nextToken());
                            System.out.println(" Headaches: " + st.nextToken());
                            System.out.println(" Allergies: " + st.nextToken());
                            System.out.println(" Bleeding Gums: " + st.nextToken());
                            System.out.println(" Heart-B.P.: " + st.nextToken());
                            System.out.println("======================================\n");
                      }
                 
                 }
                  br.close();
 
                            System.out.print(" Medical History: "); medical_history = sc_str.nextLine();
                            System.out.print(" General Health: "); general_health = sc_str.nextLine();
                            System.out.print(" Headaches: "); headaches = sc_str.nextLine();
                            System.out.print(" Allergies: "); allergies = sc_str.nextLine();
                            System.out.print(" Bleeding Gums: "); bleeding_gums = sc_str.nextLine();
                            System.out.print(" Heart-B.P.: "); heart_bp = sc_int.nextInt();

                    BufferedReader br2 = new BufferedReader(new FileReader(DB));
                      while( (rec2 = br2.readLine()) != null) {
                          if(rec2.contains(patient_id)) {
                              bw.write(patient_id + "|" + outputDate + "|" + name + "|" + address + "|" + phone_no + 
                                      "|" + b_date + "|" + age + "|" + occupation + "|" + status + "|" + medical_history + 
                                      "|" + general_health + "|" + headaches + "|"+ allergies + "|" + bleeding_gums + "|" + heart_bp);
                                          }
                          else {
                              bw.write(rec2);
                          }
                          bw.flush();
                          bw.newLine();
                          
                      }
                          bw.close();
                          br2.close();
                          DB.delete();
                          boolean Success = TempDB.renameTo(DB);
                          if(Success) {
                              System.out.println("Data has been updated SuccesFully!");
                          }
                      }

    
//  delete patient record
//    public static void deleteRecord() throws IOException {
//        System.out.println("==========DELETE RECORD==========");
//        String patient_id, rec;
//
//        File TempDB = new File("tempdb.txt");
//        File DB = new File("PatientRecordData.txt");
//
//        BufferedReader br = new BufferedReader(new FileReader(DB));
//        BufferedWriter bw = new BufferedWriter(new FileWriter(TempDB));
//
//        System.out.print(" Enter Patient ID: ");
//        patient_id = sc_str.nextLine();
//
//        while ((rec = br.readLine()) != null) {
//            if (rec.contains(patient_id)) {
//                continue;
//            }
//            bw.write(rec);
//            bw.flush();
//            bw.newLine();
//        }
//        br.close();
//        bw.close();
//
//        DB.delete();
//        TempDB.renameTo(DB);
//    }    
    
     public static void AdminSetting() throws IOException {
    	System.out.println("======================================");
        System.out.println(" || WELCOME " + f_name.toUpperCase() + " (Admin Account)\n");
        ViewUserAccount();

        Scanner x = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println(" [a] Deactivate Account   [b] Change Level [c] Change User Password");
        System.out.println(" [d] Change User Username [e] Change User FullName");
        System.out.println("======================================");
        System.out.print(" Select Operation: ");
        String operation = x.nextLine();
        System.out.println("======================================");
        System.out.print(" Enter Account ID: ");
        String account_id = x.nextLine();

        if (operation.equalsIgnoreCase("a")) {
            UpdateAccount(account_id, "Status", "");
        } else if (operation.equalsIgnoreCase("b")) {
            UpdateAccount(account_id, "Level", "");
        } else if (operation.equalsIgnoreCase("c")) {
            System.out.print(" Enter New Password: ");
            String new_password = x.nextLine();
            UpdateAccount(account_id, "Password", new_password );
        } else if (operation.equalsIgnoreCase("d")) {
            System.out.print(" Enter New Username: ");
            String new_username = x.nextLine();
            UpdateAccount(account_id, "Username", new_username );
        } else if (operation.equalsIgnoreCase("e")) {
            System.out.print(" Enter New FullName: ");
            String new_f_name = x.nextLine();
            UpdateAccount(account_id, "Fullname", new_f_name);
        }
            ViewUserAccount();
            System.out.println(" || Your Account Details ");
            System.out.println(" || ===============================");
            System.out.println(" ||  Account No.: " + user_id);
            System.out.println(" ||         Name: " + f_name);
            System.out.println(" ||     Username: " + Un);
            System.out.println(" ||     Password: " + Pw);
            System.out.println(" ||   User Level: " + user_level);
            System.out.println(" ||  User Status: " + user_status);
            System.out.println(" || User LastLog: " + user_lastlog);

    }

    public static void ViewUserAccount() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("UserSetting.txt"));
        String rec;
        String uid, fln, usn, pwd, usl, uss, ulg;
        while ((rec = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(rec, "|");
            uid = st.nextToken();
            fln = st.nextToken();
            usn = st.nextToken();
            pwd = st.nextToken();
            usl = st.nextToken();
            uss = st.nextToken();
            ulg = st.nextToken();

            System.out.printf(" %3s %-15s  %-10s  %-5s  %-8s  %-35s\n", uid, fln, usn, usl, uss, ulg);

        }

        br.close();

    }

//  Update Account info
    public static void UpdateAccount(String uid, String field, String strOption) throws IOException {

        File TempDB = new File("tempdb2.txt");
        File DB = new File("UserSetting.txt");

        BufferedReader br = new BufferedReader(new FileReader(DB));
        BufferedWriter bw = new BufferedWriter(new FileWriter(TempDB));
        String rec, rec2;

        while ((rec = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(rec, "|");
            if (rec.contains(uid)) {
                user_id = st.nextToken();
                f_name = st.nextToken();
                Un = st.nextToken();
                Pw = st.nextToken();
                user_level = st.nextToken();
                user_status = st.nextToken();
                user_lastlog = st.nextToken();
            }

        }
        br.close();
        
        if (field.equals("Log")) {
         // number 6Log"
        DateTimeFormatter fl6 = DateTimeFormatter.ofPattern("E, dd MMM yyyy hh:mm:ss a");
        String a = fl6.format(md);
        user_lastlog = a;

        }
        else if (field.equals("Status")){
            if(user_status.equals("active")) {
                user_status = "inactive";
            }
            else {
                 user_status = "active";
            }
        }
        
        else if (field.equals("Level")) {
             if(user_level.equals("admin")) {
                user_level = "user";
            }
            else {
                 user_level = "admin";
            }
        }
        else if (field.equals("Password")) {
            Pw = strOption;
        }
        else if (field.equals("Username")) {
            Un = strOption;
        }
        else if (field.equals("Fullname")) {
            f_name = strOption;
        }

        BufferedReader br2 = new BufferedReader(new FileReader(DB));
        while ((rec2 = br2.readLine()) != null) {
            if (rec2.contains(uid)) {
                String data = user_id + "|";
                data += f_name + "|";
                data += Un + "|";
                data += Pw + "|";
                data += user_level + "|";
                data += user_status + "|";
                data += user_lastlog;

                bw.write(data);
            } else {
                bw.write(rec2);
            }
            bw.flush();
            bw.newLine();

        }
        bw.close();
        br2.close();
        DB.delete();
        boolean Success = TempDB.renameTo(DB);
        if (!Success) {
            System.out.println("Error updating!!!");
        }
    }

}