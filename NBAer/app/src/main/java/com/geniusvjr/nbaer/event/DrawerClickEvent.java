package com.geniusvjr.nbaer.event;

/**
 * Created by dream on 16/4/23.
 */
public class DrawerClickEvent extends Event{

    private int drawId;

    public DrawerClickEvent(int drawId) {
        this.drawId = drawId;
    }

    public int getDrawId() {
        return drawId;
    }

}
