import java.io.FileWriter;
import java.io.IOException;

//sima html oldalak csinalja meg meg a lapozast
public class Page 
{
    private String current;
    private String previous;
    private String next;


    public Page(String previous, String current, String next) 
    {
        this.previous = previous;
        this.current = current;
        this.next = next;
    }

    public void createPage() 
    {
        try {
            FileWriter myWriter = new FileWriter(getHPath(current));
            myWriter.write(getCode());
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    // a file nevet adja vissza
    // /home/bandi16/Documents/projekt/projekt/kepek/abc.jpg -> abc.jpg
    public String getFName(String s)
    {
        String[] dirs = s.split("/");
        return dirs[dirs.length - 1];
    }
    //html megcsinalasa abc.jpg -> abc.html
    public String getHTML(String s) 
    {
        if(s.equals("")) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(this.getFName(s).split("\\.")[0]);
        sb.append(".html");
        return sb.toString();
    }

    //html linkjet adja vissza
    public String getHPath(String pth) 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(pth.split("\\.")[0]);
        sb.append(".html");
        return sb.toString();
    }

    public String getCode() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n<html>\n<body>\n");
        sb.append("\t<h1><a href=\"" + CommonUtils.getRelativePath(current) + "\">StartPage</a></h1>\n");
        sb.append("\t<hr>\n");
        sb.append("\t<p><a href=\"./index.html\">^^</a></p><br>\n");
        sb.append("\t<table>\n\t\t<tr>\n");
        sb.append("\t\t\t<td> <a href=\"" + getHTML(previous) + "\"> << </a> "+ getFName(current) + " <a href =\"" + getHTML(next) + "\"> >> </a> </td>\n");
        sb.append("\t\t</tr>\n\t\t<tr>\n");
        sb.append("\t\t\t<td> <a href=\""+ getHTML(next) +"\" ><img src=\"" + getFName(current) + "\", style=\"width: 500px;\"> </a> </td>\n");
        sb.append("\t\t<tr>\n\t<table>\n");
        sb.append("</body>\n</html>\n");
        return sb.toString();
    }
}