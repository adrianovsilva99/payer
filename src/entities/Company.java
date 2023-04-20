package entities;

public class Company extends Payer {
    private Integer numberEmployee;

    public Company(String name, Double income, Integer numberEmployee) {
        super(name, income);
        this.numberEmployee = numberEmployee;
    }

    public Integer getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(Integer numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    @Override
    public double taxesPaid() {
        if (numberEmployee > 10) {
            return getIncome() * 0.14;
        } else {
            return getIncome() * 0.16;
        }
    }
}