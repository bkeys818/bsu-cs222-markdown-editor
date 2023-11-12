package edu.bsu.cs222.markdownEditor.parser;

import edu.bsu.cs222.markdownEditor.textarea.TextStyle;
import edu.bsu.cs222.markdownEditor.textarea.segments.HiddenSyntaxSegment;
import edu.bsu.cs222.markdownEditor.textarea.segments.SegmentList;
import edu.bsu.cs222.markdownEditor.textarea.segments.TextSegment;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.util.regex.Matcher;

public class TagWrappedSyntaxReference extends SyntaxReference {
    private final InlineSyntaxType type;
    private final String tag, text;

    TagWrappedSyntaxReference(InlineSyntaxType type, Matcher matcher) {
        super(matcher);
        this.type = type;
        tag = matcher.group(1);
        text = matcher.group(2);
    }

    public SegmentList getMarkdownSegments() {
        SegmentList map = new SegmentList(start);
        map.add(new TextSegment(tag));
        map.skip(text.length());
        map.add(new TextSegment(tag));
        return map;
    }

    public SegmentList getRenderedSegments() {
        SegmentList map = new SegmentList(start);
        map.add(new HiddenSyntaxSegment(tag));
        map.skip(text.length());
        map.add(new HiddenSyntaxSegment(tag));
        return map;
    }

    public StyleSpans<TextStyle> getStyleSpans() {
        StyleSpansBuilder<TextStyle> styleSpansBuilder = new StyleSpansBuilder<>();
        styleSpansBuilder.add(type.getTextStyle().add(TextStyle.Property.Markdown), tag.length());
        styleSpansBuilder.add(type.getTextStyle(), text.length());
        styleSpansBuilder.add(type.getTextStyle().add(TextStyle.Property.Markdown), tag.length());
        return styleSpansBuilder.create();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int getTextStart() {
        return start + tag.length();
    }
}