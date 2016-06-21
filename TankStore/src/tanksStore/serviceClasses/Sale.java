package tanksStore.serviceClasses;

public class Sale {

        private float percent;
        private double sum;

        public Sale() {

        }

        public float getPercent() {
            return percent;
        }

        public void setPercent(float percent) {
            this.percent = percent;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

    @Override
    public boolean equals(Object cur) {
        Sale sale = (Sale) cur;
        if(this.getPercent() == sale.getPercent()) {
            if(this.getSum() == sale.getSum()) {
                return true;
            }
        }

        return false;
    }
}
