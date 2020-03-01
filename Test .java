import java.io.*;
public class Test{
	private static String OS = System.getProperty("os.name").toLowerCase();
	private static String command;
	private static Process proc;
//	public static String[] command;
	 public static void main(String[] args) throws Exception {
                try {

                		System.out.println("Executing on the OS : "+OS);

						if (OS.indexOf("win") >= 0) {
							System.out.println(OS);
		          			

						}
						else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0){
							System.out.println("This is Linux");

                                String line;
                                String[] cmd = { "/bin/sh", "-c", "cat /etc/os-release | grep PRETTY_NAME"};
                                Runtime rt = Runtime.getRuntime();
                                proc = rt.exec(cmd);
                                proc.waitFor();
                                StringBuffer output = new StringBuffer();
                       			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                      
                        		while ((line = reader.readLine())!= null) {
                                	output.append(line + "\n");
                        		}
                        		System.out.println("### " + output);
						}

						else if(OS.indexOf("mac") >= 0){
							System.out.println("This is MAC OS");
						}
						else if(OS.indexOf("sunos") >= 0){
							System.out.println("This is Solaris OS");
						}
						else
						{
							System.out.println("Not supported OS");
						}

                } catch (Throwable t) {
                        t.printStackTrace();
                }
        }
}
