//linkek letrehozasa direkehez es a fileokhoz
public class Linker 
{
    private String path;

    public Linker(String path) 
    {
        this.path = path;
    }

    public String getFileName() {

        String[] dirs = this.path.split("/");
        return dirs[dirs.length - 1];
    }

    public String getHPath() {
        StringBuilder sb = new StringBuilder();

        if(this.path.contains(".")) {
            sb.append(this.path.split("\\.")[0]);
            sb.append(".html");
        }
        else {
            sb.append(this.path + "/index.html");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "<li><a href=\"./" + CommonUtils.getFName(getHPath()) + "\"> " + getFileName() + " </a></li>\n";
    }
}