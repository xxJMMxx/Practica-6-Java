public class Hexagono {

        private double cateto;
        private double perimetro;
        private double apotema;
        private double area;

        public Hexagono(double cateto){
            this.cateto = cateto;
            this.calcularPerimetro();
            this.calcularApotema();
            this.calcularArea();
        }

    public double getCateto() {
        return cateto;
    }

    public void setCateto(double cateto) {
        this.cateto = cateto;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double getApotema() {
        return apotema;
    }

    public void setApotema(double apotema) {
        this.apotema = apotema;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void calcularPerimetro(){this.perimetro = this.cateto * 6;}

    public void calcularApotema(){this.apotema = (Math.sqrt((this.cateto * this.cateto) - ((this.cateto / 2) * (this.cateto / 2))));}

    public void calcularArea(){this.area = (this.perimetro * this.apotema)/2;}

    public static void main(String[] args){
        Hexagono Hex = new Hexagono(6);
        System.out.println(Hex.getPerimetro());
        System.out.println(Hex.getApotema());
        System.out.println(Hex.getArea());
    }
}



