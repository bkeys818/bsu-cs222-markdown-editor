package edu.bsu.cs222.markdownEditor.segments;

import org.fxmisc.richtext.TextExt;

public class MarkdownSegment {

    private final String text;

    public MarkdownSegment() {
        this("");
    }

    public MarkdownSegment(String text) {
        this.text = text;
    }

    public boolean isPlainText() {
        return true;
    }

    public int length() {
        return text.length();
    }

    public char charAt(int index) {
        return text.charAt(index);
    }

    public String getText() {
        return text;
    }

    public MarkdownSegment subSequence(int start, int end) {
        return new MarkdownSegment(text.substring(start, end));
    }

    public TextExt styleNode(TextExt textNode) {
        textNode.setText(text);
        return textNode;
    }
}
