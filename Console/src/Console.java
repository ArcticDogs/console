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
            else if(console.length() >= 19) {
            	if(console.substring(0,19).equalsIgnoreCase("get_random_password")) {

	            	int value = Integer.parseInt(sc.next());
	            	
	            	if(value > 64) {
	            		System.out.println("Error: \"" + value + "\" is too large, try values [8 - 64] for \"" + console + "\"");
	            	}
	            	else if(value < 8) {
	            		System.out.println("Error: \"" + value + "\" is too small, try values [8 - 64] for \"" + console + "\"");
	            	}
	            	else {
	            		System.out.println(box.getRandomPassword(value));
	            	}
	
	            }
            }
            else if(console.equalsIgnoreCase("help")){
                System.out.println("\nget_ip\nget_time\nget_random_password [8-64]\nend_task\n");
            }

            else{
                System.out.println("Error: Command not found, type \"help\" for more commands");
            }
        }while(!console.equalsIgnoreCase("end_task"));


    }

    public String whatismyIP(){
        return ip;
    }

    public String whatistheTime(){
    	time = System.currentTimeMillis();
        Date day = new Date(time);
        return day.toString();
    }
    
    public String getRandomPassword(int value) {
    	String password = "";
    	
    	
    	return password;
    }
}



