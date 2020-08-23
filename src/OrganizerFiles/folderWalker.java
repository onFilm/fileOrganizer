package OrganizerFiles;

import java.io.File;

public class folderWalker {

    public static void walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
                //System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
               // System.out.println( "File:" + f.getAbsoluteFile() );
                main.copySingleFile(f.getAbsolutePath(),f.getName());
            }
        }
    }
}