
package sectionlist;

public class PinnedItem {

    public static final int ITEM = 0;
    public static final int SECTION = 1;
    public static final int FILTER = 2;
    public static final int FILTER_INLINE = 3;
    public static final int INFO = 4;

    public final int type;
    public final String text;
    public final Object tag;

    public int sectionPosition;
    public int listPosition;
    public int itemPosition;

    public PinnedItem(int type, String text) {
        this.type = type;
        this.text = text;
        this.tag = null;
    }

    public PinnedItem(int type, String text, Object tag) {
        this.type = type;
        this.text = text;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return text;
    }

}
