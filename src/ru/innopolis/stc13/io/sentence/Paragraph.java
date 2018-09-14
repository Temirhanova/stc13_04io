package ru.innopolis.stc13.io.sentence;

public class Paragraph {
    private int size;
    private String paragraph = "";
    private String sentenseForParagraph = "";
    private String endParagrahp = "\n\r";

    public Paragraph(int size, String settenceArray) {
        this.size = size;
        this.sentenseForParagraph = settenceArray;
    }

    public String generateParagraph() {
        Sentense sentense;
        for (int i=0; i<this.size; i++) {
            this.paragraph += this.sentenseForParagraph + " ";
        }
        this.paragraph += endParagrahp;
        return this.paragraph;
    }
}
