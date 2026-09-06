class RotateString {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder(goal);
        sb.append(goal);
        if (sb.toString().contains(s)) {
            return true;
        }
        return false;
    }
};