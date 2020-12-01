/*
 File name: FastaDocChecker.java -- to be used with Fasta.java & DNA.java
 Program author: Analia Treviño-Flitton
 */

import java.util.Arrays;
import java.util.Scanner;




/* Extension from DNA class to Fasta class w/ setter/getter array constructor
   - Reads in file & searchES contents for user Seq ID
   - If ID present, will parse out all IDs/ sequences & save to array
   - If not present will reprompt or until user enters quit
*/


public class FastaDocChecker {

    public static void main(String[] args) {

        // Instantiate new objects & variables
        Scanner input = new Scanner(System.in);
        Fasta fasta = new Fasta();
        boolean end;


        System.out.println("Please enter the path to the fasta file:");
        String FilePath = (input.nextLine());
        System.out.println("Please enter the seq ID:");
        String userSeqID = (input.nextLine().toLowerCase());


        // Call reader & return if ID was found or if program should end
        end = fasta.FastaReader(FilePath, userSeqID);

        // While end is not true, reprompt for file/sequence ID & call Fasta Reader
        while (end != true) {
            System.out.println("Please try again or enter 'quit' to exit the program");
            System.out.println( "Please enter the path to the fasta file:");
            FilePath = (input.nextLine());
            System.out.println("Please enter the seq ID:");
            userSeqID = (input.nextLine().toLowerCase());
            end = fasta.FastaReader(FilePath, userSeqID);
        }


        // Printing
        if (end && !userSeqID.equals("quit") ) {
            String[] idChecker = (String[]) fasta.getSeqIDList();
            String[] seqChecker = (String[]) fasta.getDnaSeqList();
           int x = Arrays.asList(idChecker).indexOf(userSeqID);


            String dnaseq = (seqChecker[x] );
            fasta.setDnaSeq(dnaseq);

            System.out.println("\n" +seqChecker[x] + "\n");

        }

        // Call methods from DNA class
        fasta.IsDNA();
        fasta.getSize();
        fasta.baseCount('A');
        fasta.gcContent();


        System.out.println("\nWritten by: Analia Treviño-Flitton");
    }
}



