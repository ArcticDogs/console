import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;
public class Console {
    private String ip;
    private long time;
    public Console(){
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
            time = System.currentTimeMillis();
    }

    public static void main(String[] args) throws UnknownHostException {
        Console box = new Console();

        String console = "";
            System.out.println("Opened up: Console");
         do{
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            console = sc.next();

            if (console. equalsIgnoreCase("get_ip")) {
                System.out.println(box.whatismyIP());
            }
            else if (console.equalsIgnoreCase("get_time")) {
                System.out.println(box.whatistheTime());
            }
            else if(console.equalsIgnoreCase("help")){
                System.out.println("\nget_ip\nget_time\nend_task\n");
            }
            else{
                System.out.println("Error: Command not found, type \"help\" for more commands");
            }
        }while(!console.equals("end_task"));


    }

    public String whatismyIP(){
        return ip;
    }

    public String whatistheTime(){
        Date day = new Date(time);
        return day.toString();
    }
}