package com.example.ka.drag_drop;

public interface ItemTouchListenner {
    void onMove(int oldPosition, int newPosition);

    void swipe(int position, int direction);
}
