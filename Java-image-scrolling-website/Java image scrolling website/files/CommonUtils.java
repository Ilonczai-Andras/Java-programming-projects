import java.io.File;

//tobb helyen hasznalt dolgok
public class CommonUtils 
{
    private CommonUtils() 
    {
        //empty
    }

    public static String root;

    public static String getRelativePath(String actual) 
    {
        int until = root.length();
        String remainder = actual.substring(until, actual.length());
        String[] dirs = remainder.split("/");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < dirs.length - 2; i++) 
        {
            sb.append("../");
        }
        sb.append("index.html");

        return sb.toString();
    }

    public static boolean isRoot(String path) 
    {
        return root.equals(path);
    }

    public static boolean isValid(String path) 
    {
        return path.endsWith(".jpg") || path.endsWith(".jpeg") || path.endsWith(".png");
    }

    public static String getFName(String pth) 
    {

        if(pth.endsWith("/index.html")) 
        {
            String[] dirs = pth.split("/");
            return dirs[dirs.length - 2] + "/index.html";
        }

        String[] dirs = pth.split("/");
        return dirs[dirs.length - 1];
    }

    public static String getFName(File f) 
    {
        String s = f.getAbsolutePath();
        String[] dirs = s.split("/");
        return dirs[dirs.length - 1];
    }
}
