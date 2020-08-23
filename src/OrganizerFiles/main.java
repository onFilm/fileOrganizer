package OrganizerFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 *
 * @author Prajwal
 */

public class main {
	final static String COPY_PATH = "C:\\Editing\\MobileBackup\\";
	final static String PASTE_PATH = "C:\\Editing\\FileOrganizer\\";
	final static String folders[] = { "Applications", "Pictures", "Videos", "Archives", "Documents", "Others" };

	@Test
	public void run() {

		// Create folders if not created inside Paste Dir
		for (String string : folders) {
			createFolder(string);
		}

		// FolderWalk and move all files
		folderWalker.walk(COPY_PATH);

	}

	public static String createFolder(String folderName) {

		Path path = Paths.get(PASTE_PATH + folderName);
		try {
			path = Files.createDirectory(path);
		} catch (IOException ex) {
			System.out.println("Directory is exist");
		}
		System.out.println(path.toString());
		return path.toString();
	}

	public static void copySingleFile(String string, String name) {
		System.out.println(string);
		int lastIndex = string.toString().lastIndexOf(".");// example: .png
		String ext = string.toString().substring(lastIndex + 1).toLowerCase(); 

		System.out.println(ext);
		try {
			switch (ext) {
			case "jpeg":
			case "jpg":
			case "png":
			case "gif":
			case "bmp":
			case "ico":
				FileUtils.moveFileToDirectory(new File(Paths.get(string).toString()),new File(PASTE_PATH + "Pictures\\"), true);
				break;

			case "mp4":
			case "flv":
			case "mp3":
			case "wmv":
			case "3gp":
			case "avi":
			case "mov":
				FileUtils.moveFileToDirectory(new File(Paths.get(string).toString()), new File(PASTE_PATH + "Videos\\"),true);
				break;

			case "zip":
			case "tar":
			case "gz":
				FileUtils.moveFileToDirectory(new File(Paths.get(string).toString()),new File(PASTE_PATH + "Archives\\"), true);
				break;

			case "docx":
			case "doc":
			case "pdf":
			case "ppt":
			case "pptx":
			case "xls":
			case "txt":
			case "odt":
			case "ott":
			case "xml":
			case "csv":
				FileUtils.moveFileToDirectory(new File(Paths.get(string).toString()),new File(PASTE_PATH + "Documents\\"), true);
				break;

			case "exe":
			case "sh":
			case "dmg":
			case "msi":
			case "pkg":
				FileUtils.moveFileToDirectory(new File(Paths.get(string).toString()),new File(PASTE_PATH + "Applications\\"), true);
				break;

			case "json":
			case "php":
			case "css":
			case "sql":
			case "py":
			case "mo":
			case "po":
			case "jar":
			case "war":
				FileUtils.moveFileToDirectory(new File(Paths.get(string).toString()), new File(PASTE_PATH + "Others\\"),true);
				break;

			default:
				FileUtils.moveFileToDirectory(new File(Paths.get(string).toString()), new File(PASTE_PATH + "Others\\"),true);
				break;
			}

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}

	}
}
