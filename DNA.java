/*
File name: DNA.java- DNA class meant to be used with FastaDocChecker
           Fasta is a subclass of DNA
Program author name: Analia Treviño-Flitton
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class DNA {
    // initialize variables
    private String DnaSeq;
    private String seqID;
    private String[] dnaSeqList;
    private String[] seqIDList;
    char ch;
    float countSize;
    float count_base;



    // Get/Set Fasta SeqList & ID List from Fasta subclass
    public String[] getDnaSeqList() {
        return dnaSeqList;
    }

    public void setDnaSeqList(String[] dnaSeqList) {
        this.dnaSeqList = dnaSeqList;
    }

    public String[] getSeqIDList() {
        return seqIDList;
    }

    public void setSeqIDList(String[] seqIDList) {
        this.seqIDList = seqIDList;
    }



    //Get/SetSeq
    public void setDnaSeq(String dnaSeq) {
        DnaSeq = dnaSeq;
    }

    public String getDnaSeq() {
        return DnaSeq;
    }

    public String getSeqID() {
        return seqID;
    }

    public void setSeqID(String seqID) {
        this.seqID = seqID;
    }



    public void IsDNA() {
        // Initialize a regex to search for DNA bases only
        Pattern pattern = Pattern.compile("[ATGC]+");
        Matcher match = pattern.matcher(DnaSeq);

        // If checker is true, it is a valid seq. Else it is invalid
        System.out.println(match.matches() ? "This is a valid DNA sequence" : "This is not a valid DNA sequence");
    }




    public void getSize() {
        // Count every character in the sequence
        countSize = 0;
        for (int i = 0; i <= DnaSeq.length() - 1; i++) {
            countSize++;
        }

        // Print the results
        System.out.println("DNA Sequence Length: " + countSize );

    }




    public void baseCount(char base) {
        // Count every instance of the base in the DNA seq
        count_base = 0;
        for (int i = 0; i <= DnaSeq.length() - 1; i++) {
            ch = DnaSeq.charAt(i);

            // If the character is the base, add to the count
            if (ch == base) {
                count_base++;
            }
        }
        // Print the results
        System.out.println("Base count for " + base + ": " +count_base);



    }



    public void gcContent() {
        float count_GC = 0;

        // For every instance of G or C, add to count
        for (int i = 0; i <= DnaSeq.length() - 1; i++) {
            ch = DnaSeq.charAt(i);
            if (ch == 'C' || ch == 'G') {
                count_GC++;
            }
        }
        // Find total GC content
        float total = ( (count_GC) / DnaSeq.length() *100);

        // Print the results
        System.out.println("The GC content is: " + total + "%");

    }



}