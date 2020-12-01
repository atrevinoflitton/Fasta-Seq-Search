# Fasta-Seq-Search
Parses a FASTA document for the user provided sequence ID to return the sequence. Subclass of DNA with methods to find:

* Whether it is a valid DNA sequence

* Sequence Length

* Specific base count

* GC content 


<dl>
  <dt> Required files for program </dt>
  
  <dd>

--- 
FastaDocChecker.java
* Holds main class to call Fasta reader and parser, calls the DNA methods
---
Fasta.java
* Contains the Fasta file reader and Fasta parser methods. Sets the DNA sequence list for access in DNA 
---
DNA.java
* Class with various DNA tools

*Not required for FastaDocChecker to run but methods have been included for functionality*

---
seq.fasta
* Various FASTA formatted DNA sequences
---
</dt>
