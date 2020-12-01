/*
 File name: Fasta.java  -- to be used with FastaDocChecker.java & DNA.java
 Program author: Analia Treviño-Flitton
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;



public class Fasta extends DNA {


    boolean FastaReader ( String FilePath, String userSeqID) {
        boolean end = false;


        // Read the file line by line & catch exceptions
        try {

            // Initialize
            BufferedReader read = new BufferedReader(new FileReader( FilePath ));
            StringBuilder buildString = new StringBuilder();
            String fileLine = "";


            // While there is a line in the file, read & add to string builder
            while (( fileLine = read.readLine()) != null) {
                buildString.append( fileLine );
            }
            read.close();


            // Send builder to string for regex search of seq ID
            String fileContents = buildString.toString();
            Pattern pattern = Pattern.compile( userSeqID );
            Matcher match = pattern.matcher( fileContents );


            // If seq ID present call parser -- if not re-prompt or end with quit
            if (match.find()) {
                FastaParser( fileContents );
                end = true;
                return end;

            } else if ( userSeqID.equals("quit") ) {
                System.out.println("\nWritten by: Analia Treviño-Flitton");
                end = true;
                return end;

            } else {
                System.out.println("The sequence ID " + userSeqID + " is not in this file.");
            }


        } catch ( FileNotFoundException e) {
            System.out.println("Unable to locate file.");


        } catch ( IOException ioException ) {
            System.out.println("Please retry with a readable file-type");

        }

        return end;
    }





    void FastaParser (String fileContents){

        // Initialize
        ArrayList<String> seqList = new ArrayList<String>();
        ArrayList<String> headerList = new ArrayList<String>();


        // Regex for Sequence IDs
        String headerRegex = "[^>](\\w+\\.\\w{2})" ;
        Pattern pHeader = Pattern.compile( headerRegex );
        Matcher mHeader = pHeader.matcher( fileContents );

        // While found add to array list
    while ( mHeader.find() ){
        headerList.add(mHeader.group());
    }


        // Regex for Sequences
        String seqRegex = "([ATGC]+)";
        Pattern pSeq= Pattern.compile( seqRegex );
        Matcher mSeq = pSeq.matcher( fileContents );

        while ( mSeq.find() ){
            seqList.add( mSeq.group() );
        }


        String[] SeqIDList = headerList.toArray(new String [ headerList.size() ]);
        String[] dnaSeqList = seqList.toArray(new String [ seqList.size() ]);


        // Set array to DNA class
        setSeqIDList( SeqIDList );
        setDnaSeqList( dnaSeqList );

    }

}