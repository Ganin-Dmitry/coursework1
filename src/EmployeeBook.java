public class EmployeeBook {

    private Employee[] employees;
    private static int id = 0;

    public EmployeeBook (Employee [] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees () {
        return this.employees;
    }

    public void printListEmployees () {
        String fullList = "";
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] != null) {
                fullList = fullList + this.getEmployees()[employer].toString() + "\n";
            }
        }
        System.out.println(fullList);
    }

    public void addNewEmployer (String name, String surname, String patronymic, int department, float wages) {
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] == null) {
                this.getEmployees()[employer] = new Employee(surname, name, patronymic, department, wages, id);
                System.out.println("Сотрудник добавлен");
                id++;
                break;
            } else if (employer == this.getEmployees().length - 1) {
                System.out.println("Нет пустых ячеек в массиве");
            }
        }
    }

    public float calculateMiddleWages () {
        float sumWages = 0;
        int value = 0;
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] != null) {
                sumWages += this.getEmployees()[employer].getWages();
                value++;
            }
        }
        return sumWages / value;
    }

    public float calculationTax (String scheme) {
        float taxSum = 0f;
        switch (scheme) {
            case "PROPORTIONAL":
                for (int employer = 0; employer < this.getEmployees().length; employer++) {
                    if (this.getEmployees()[employer] != null) {
                        taxSum = taxSum + this.getEmployees()[employer].getWages() * 0.13f;
                    }
                }
                break;
            case "PROGRESSIVE":
                for (int employer = 0; employer < this.getEmployees().length; employer++) {
                    if (this.getEmployees()[employer] != null && this.getEmployees()[employer].getWages() < 150000) {
                        taxSum = taxSum + this.getEmployees()[employer].getWages() * 0.13f;
                    } else if (this.getEmployees()[employer] != null && this.getEmployees()[employer].getWages() < 350000) {
                        taxSum = taxSum + this.getEmployees()[employer].getWages() * 0.17f;
                    } else {
                        taxSum = taxSum + this.getEmployees()[employer].getWages() * 0.21f;
                    }
                }
                break;
            default:
                System.out.println("Неизвестная схема подсчета налогов.");
        }
        return taxSum;
    }

    public void indexationWages (int department, int percent) {
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] != null && this.getEmployees()[employer].getDepartment() == department) {
                this.getEmployees()[employer].setWages(this.getEmployees()[employer].getWages() + this.getEmployees()[employer].getWages() * percent / 100);
            }
        }
        System.out.println("Зарплаты проиндексированы на " + percent + "%");
    }

    public void searchingEmployeeHigherWages (int department, float wages) {
        Employee employee = null;
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] != null && department == this.getEmployees()[employer].getDepartment() && this.getEmployees()[employer].getWages() > wages) {
                employee = this.getEmployees()[employer];
                break;
            }
        }
        System.out.println(employee.toString());
    }

    public void searchingEmployeeHigherWages (float wages) {
        Employee employee = null;
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] != null && this.getEmployees()[employer].getWages() > wages) {
                employee = this.getEmployees()[employer];
                break;
            }
        }
        System.out.println(employee.toString());
    }

    public void searchingEmployeesLowerWages (float wages, int quantity) {
        int register = 1;
        String employee = "";
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] != null && this.getEmployees()[employer].getWages() < wages && quantity >= register) {
                employee = employee + this.getEmployees()[employer].toString() + "\n";
                register++;
            }
        }
        System.out.println(employee);
    }

    public boolean availabilityEmployee (Employee employee) {
        boolean found = false;
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer].equals(employee)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public Employee searchById (int id) {
        Employee employee = null;
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] == null) {
                continue;
            }
            if (this.getEmployees()[employer].getId() == id) {
                employee = this.getEmployees()[employer];
            }
        }
        return employee;
    }

    public void deleteById (int id) {
        for (int employer = 0; employer < this.getEmployees().length; employer++) {
            if (this.getEmployees()[employer] == null) {
                continue;
            }
            if (this.getEmployees()[employer].getId() == id) {
                this.getEmployees()[employer] = null;
            }
        }
    }

}
