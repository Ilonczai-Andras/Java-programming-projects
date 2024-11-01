import java.io.File;

public class Main {
    public static void main(String[] args) 
    {
        if(args.length != 1) 
        {
            errorExit();
        }

        String path = args[0];

        //eleresi ut nem tartalmaz semmit
        if(!new File(path).exists()) 
        {
            errorExit();
        }

        //fo oldal eleresi utvonala
        CommonUtils.root = path;

        Crawler cw = new Crawler(path);
        cw.start();
    }

    public static void errorExit() {
        System.err.println("Error! Please provide a valid path!");
        System.exit(1);
    }
}