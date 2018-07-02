package org.dav.learn.simplesynth;

public class DescriptPair
{
    private String caption;
    private String hint;

    public DescriptPair(String caption, String hint)
    {
        this.caption = caption;
        this.hint = hint;
    }

    public String getCaption()
    {
        return caption;
    }

    public String getHint()
    {
        return hint;
    }
}
