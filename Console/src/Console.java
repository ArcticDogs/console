package console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class Console {
    private String ip;
    private String weather;
    private long time;

    public Console() {
    //http://api.openweathermap.org/data/2.5/weather?zip=75063,us&APPID=3d152c10dbf2c7dba2876e9029490a94&units=imperial
        URL url = null;
        try {
            url = new URL("https://api.ipify.org/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ip = (br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws UnknownHostException {
        Console box = new Console();

        String console = "";
        System.out.println("Opened up: Console");
        do {
            System.out.print("Input: ");
            Scanner sc = new Scanner(System.in);
            console = sc.next();

            if (console.equalsIgnoreCase("get_ip")) {
                System.out.println(box.whatismyIP());
            } 
            else if (console.equalsIgnoreCase("get_time")) {
                System.out.println(box.whatistheTime());
            } 
            else if (console.length() >= 19) {
                if (console.substring(0, 19).equalsIgnoreCase("get_random_password")) {

                    int value = Integer.parseInt(sc.next());

                    if (value > 64) {
                        System.out.println("Error: \"" + value + "\" is too large, try values [8- 64] for \"" + console + "\"");
                    } else if (value < 8) {
                        System.out.println("Error: \"" + value + "\" is too small, try values [8 - 64] for \"" + console + "\"");
                    } else {
                        System.out.println(box.getRandomPassword(value));
                    }

                }
            } 
            else if (console.length() >= 11) {
                if (console.substring(0, 11).equalsIgnoreCase("get_weather")) {

                    String zipcode = sc.next();
                    String weather = box.getWeather(zipcode);
                    if (weather != null) {
                        System.out.println(weather);
                    }

                }
            } 
            else if (console.equalsIgnoreCase("help")) {
                System.out.println("\nget_ip\nget_time\nget_random_password [8-64]\nget_weather [zipcode]\nend_task\n");
            } 
            else {
                if (!console.equalsIgnoreCase("end_task"))
                    System.out.println("Error: Command not found, type \"help\" for more commands");
            }

        } while (!console.equalsIgnoreCase("end_task"));


    }

    public String whatismyIP() {

        return ip;

    }

    public String whatistheTime() {
        time = System.currentTimeMillis();
        Date day = new Date(time);
        return day.toString();
    }

    public String getRandomPassword(int value) {
        String password = "";
        String[] charPass = new String[]{
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "abcdefghijklmnopqrstuvwxyz",
                "1234567890",
                ".@,/()#$%^&*!"
        };

        for (int x = 0; x < value; x++) {
            int ran = (int) (Math.random() * 11);
            if (ran <= 3) {
                int captital = (int) (Math.random() * 26);
                password += String.valueOf(charPass[0].charAt(captital));

            } else if (ran <= 6) {
                int captital = (int) (Math.random() * 26);
                password += String.valueOf(charPass[1].charAt(captital));


            } else if (ran <= 8) {
                int captital = (int) (Math.random() * 10);
                password += String.valueOf(charPass[2].charAt(captital));


            } else if (ran <= 10) {
                int captital = (int) (Math.random() * 13);
                password += String.valueOf(charPass[3].charAt(captital));
            }
        }
        return password;
    }

    public String getWeather(String zip) {
        URL weatherURL = null;
        try {
            weatherURL = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zip + ",us&APPID=3d152c10dbf2c7dba2876e9029490a94&units=imperial");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader weabr = null;
        try {
            weabr = new BufferedReader(new InputStreamReader(weatherURL.openStream()));
            try {
                String weaJson = (weabr.readLine());
                weaJson = weaJson.substring(188, 220);
                weaJson = weaJson.replace(",", " ");
                weaJson = weaJson.replaceAll("\"", "");
                weaJson = weaJson.replaceFirst(" ", "");
                weather = weaJson;

            } catch (IOException e) {
                System.out.println("Error invalid zipcode");
            }
        } catch (IOException e) {
            System.out.println("Error invalid zipcode");

            //e.printStackTrace();
        }

        return weather;
    }
}
