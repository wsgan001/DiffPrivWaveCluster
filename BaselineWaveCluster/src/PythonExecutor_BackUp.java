import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class PythonExecutor_BackUp {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws Exception
	 */
	
	public static void ExecuteKDTree(String folder) throws Exception{
		String folder = "E:/D_disk/workspace/Python Workspace/KD-TreeGenerationBeingCalledForUsefulness/src";
		String outputfile = "\"E:/D_disk/workspace/Python Workspace/KD-TreeGenerationBeingCalledForUsefulness/KDTreeOutput.txt\"";
		int eps = 1;
		String inputfile = "dataset/tiger_NMWA.dat";

		String command = "c:/Python27/python.exe MainExp.py" + " " + outputfile
				+ " " + eps + " " + inputfile;

		Process tr = Runtime.getRuntime().exec(command, null, new File(folder));
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				tr.getInputStream()));

		String line = null;
		while ((line = rd.readLine()) != null) {
			System.out.println(line);

		}

		BufferedReader rd2 = new BufferedReader(new InputStreamReader(
				tr.getErrorStream()));

		line = null;
		while ((line = rd2.readLine()) != null) {
			System.out.println(line);

		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String folder = "E:/D_disk/workspace/Python Workspace/KD-TreeGenerationBeingCalledForUsefulness/src";
		String outputfile = "\"E:/D_disk/workspace/Python Workspace/KD-TreeGenerationBeingCalledForUsefulness/KDTreeOutput.txt\"";
		int eps = 1;
		String inputfile = "dataset/tiger_NMWA.dat";

		String command = "c:/Python27/python.exe MainExp.py" + " " + outputfile
				+ " " + eps + " " + inputfile;

		Process tr = Runtime.getRuntime().exec(command, null, new File(folder));
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				tr.getInputStream()));

		String line = null;
		while ((line = rd.readLine()) != null) {
			System.out.println(line);

		}

		BufferedReader rd2 = new BufferedReader(new InputStreamReader(
				tr.getErrorStream()));

		line = null;
		while ((line = rd2.readLine()) != null) {
			System.out.println(line);

		}

	}
}
