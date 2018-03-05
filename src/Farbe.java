public enum Farbe {
    Hellgrün,
    Blau,
    Weiß;

    public String farbe() {
        switch (this) {
            case Hellgrün:
                return "-fx-background-color: #00ff00";
            case Blau:
                return "-fx-background-color:  #00bfff";
            case Weiß:
                return  "-fx-background-color: #ffffff";
            default:
                return "-fx-background-color: #ffffff";
        }

    }


}
