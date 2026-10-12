import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Employee [] arrListEmployer = new Employee[10];
        EmployeeBook listEmployer = new EmployeeBook(arrListEmployer);
        int wages;
        int department;
        int id;
        String surname;
        String name;
        String patronymic;
        int quantity;
        int percent;
        listEmployer.addNewEmployer("Андрей", "Сатыпов", "Генадиевич", 1, 390500f);
        listEmployer.addNewEmployer("Алёша", "Алёшов", "Алёшевич", 1, 195300f);
        listEmployer.addNewEmployer("Светлана", "Миронова", "Григорьевна", 2, 96800f);
        listEmployer.addNewEmployer("Ирина", "Евстегнеева", "Николаевна", 2, 98400f);
        listEmployer.addNewEmployer("Станислав", "Михайлов", "Ерефемович", 3, 122700f);
        listEmployer.addNewEmployer("Илья", "Кубинских", "Алексеевич", 3, 99700f);
        listEmployer.addNewEmployer("Арина", "Ганина", "Сергеевна", 4, 81400f);
        listEmployer.addNewEmployer("Алиса", "Турова", "Алексеевна", 4, 50050f);
        listEmployer.addNewEmployer("Роман", "Шапырин", "Акакиевич", 5, 55200f);
        listEmployer.addNewEmployer("Диман", "Диванов", "Матрасович", 5, 50900f);
        while (true) {
            System.out.println("Выберите действие:\n1. Новый сотрудник\n2. Поиск\n3. Все сотрудники\n4. Финансы");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Введите фамилию:");
                    surname = scanner.next();
                    System.out.println("Введите имя:");
                    name = scanner.next();
                    System.out.println("Введите отчество:");
                    patronymic = scanner.next();
                    System.out.println("Введите № отдела:");
                    department = scanner.nextInt();
                    System.out.println("Введите ЗП:");
                    wages = scanner.nextInt();
                    listEmployer.addNewEmployer(name, surname, patronymic, department, wages);
                    break;
                case 2:
                    System.out.println("Выберите действие:\n1. Найти по ID\n2. Найти по ЗП\n3. Выйти");
                    switch (scanner.nextInt()) {
                        case 1:
                            System.out.println("Введите ID");
                            id = scanner.nextInt();
                            if (listEmployer.searchById(id) == null) {
                                System.out.println("Сотрудник не найден");
                                break;
                            }
                            System.out.println(listEmployer.searchById(id).toString());
                            System.out.println("Выберите действие:\n1. Изменить\n2. Удалить\n3. Выйти");
                            switch (scanner.nextInt()) {
                                case 1:
                                    System.out.println("Выберите действие:\n1. Изменить Ф.И.О.\n2. Изменить № отдела\n3. Изменить ЗП\n4. Выйти");
                                    switch (scanner.nextInt()) {
                                        case 1:
                                            System.out.println("Введите фамилию");
                                            surname = scanner.next();
                                            System.out.println("Введите имя");
                                            name = scanner.next();
                                            listEmployer.searchById(id).setSurname(surname);
                                            listEmployer.searchById(id).setName(name);
                                            break;
                                        case 2:
                                            System.out.println("Введите № отдела");
                                            department = scanner.nextInt();
                                            listEmployer.searchById(id).setDepartment(department);
                                            break;
                                        case 3:
                                            System.out.println("Введите ЗП");
                                            wages = scanner.nextInt();
                                            listEmployer.searchById(id).setWages(wages);
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Неправильно выбрано действие");
                                            break;
                                    }
                                    break;
                                case 2:
                                    listEmployer.deleteById(id);
                                    System.out.println("Данные о сотруднике удалены");
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Неправильно выбрано действие");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Выберите действие:\n1. Больше от заданной ЗП по отделу\n2. Заданное колличество сотрудников с ЗП меньше заданной\n3. Выйти");
                            switch (scanner.nextInt()) {
                                case 1:
                                    System.out.println("Выберите отдел: 1  2  3  4  5\n6. Все отделы\n7. Выйти");
                                    switch (scanner.nextInt()) {
                                        case 1:
                                            System.out.println("Введите значение ЗП");
                                            wages = scanner.nextInt();
                                            listEmployer.searchingEmployeeHigherWages(1, wages);
                                            break;
                                        case 2:
                                            System.out.println("Введите значение ЗП");
                                            wages = scanner.nextInt();
                                            listEmployer.searchingEmployeeHigherWages(2, wages);
                                            break;
                                        case 3:
                                            System.out.println("Введите значение ЗП");
                                            wages = scanner.nextInt();
                                            listEmployer.searchingEmployeeHigherWages(3, wages);
                                            break;
                                        case 4:
                                            System.out.println("Введите значение ЗП");
                                            wages = scanner.nextInt();
                                            listEmployer.searchingEmployeeHigherWages(4, wages);
                                            break;
                                        case 5:
                                            System.out.println("Введите значение ЗП");
                                            wages = scanner.nextInt();
                                            listEmployer.searchingEmployeeHigherWages(5, wages);
                                            break;
                                        case 6:
                                            System.out.println("Введите значение ЗП");
                                            wages = scanner.nextInt();
                                            listEmployer.searchingEmployeeHigherWages(wages);
                                            break;
                                        case 7:
                                            break;
                                        default:
                                            System.out.println("Неправильно выбрано действие");
                                            break;
                                    }
                                    break;
                                case 2:
                                    System.out.println("Введите колличество сотрудников");
                                    quantity = scanner.nextInt();
                                    System.out.println("Введите значение ЗП");
                                    wages = scanner.nextInt();
                                    listEmployer.searchingEmployeesLowerWages(wages, quantity);
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Неправильно выбрано действие");
                                    break;
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Неправильно выбрано действие");
                            break;
                    }
                    break;
                case 3:
                    listEmployer.printListEmployees();
                    break;
                case 4:
                    System.out.println("Выберите действие:\n1. Вывести среднее значение ЗП\n2. Вывести значение налогов\n3. Индексация ЗП\n4. Выйти");
                    switch (scanner.nextInt()) {
                        case 1:
                            System.out.println("Среднее значение ЗП равно: " + listEmployer.calculateMiddleWages());
                            break;
                        case 2:
                            System.out.println("Выберите способ рассчета:\n1. ПРОПОРЦИОНАЛЬНО\n2. ПРОГРЕССИВНО\n3. Выйти");
                            switch (scanner.nextInt()) {
                                case 1:
                                    System.out.println("Сумма налогов по пропорциональной схеме рассчета: " + listEmployer.calculationTax("PROPORTIONAL"));
                                    break;
                                case 2:
                                    System.out.println("Сумма налогов по прогрессивной схеме рассчета: " + listEmployer.calculationTax("PROGRESSIVE"));
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Неправильно выбрано действие");
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("Выберите отдел: 1  2  3  4  5\n6. Все отделы\n7. Выйти");
                            switch (scanner.nextInt()) {
                                case 1:
                                    System.out.println("Введите значение процента индексации");
                                    percent = scanner.nextInt();
                                    listEmployer.indexationWages(1, percent);
                                    System.out.println("ЗП в 1 отделе проиндексированы");
                                    break;
                                case 2:
                                    System.out.println("Введите значение процента индексации");
                                    percent = scanner.nextInt();
                                    listEmployer.indexationWages(2, percent);
                                    System.out.println("ЗП в 1 отделе проиндексированы");
                                    break;
                                case 3:
                                    System.out.println("Введите значение процента индексации");
                                    percent = scanner.nextInt();
                                    listEmployer.indexationWages(3, percent);
                                    System.out.println("ЗП в 1 отделе проиндексированы");
                                    break;
                                case 4:
                                    System.out.println("Введите значение процента индексации");
                                    percent = scanner.nextInt();
                                    listEmployer.indexationWages(4, percent);
                                    System.out.println("ЗП в 1 отделе проиндексированы");
                                    break;
                                case 5:
                                    System.out.println("Введите значение процента индексации");
                                    percent = scanner.nextInt();
                                    listEmployer.indexationWages(5, percent);
                                    System.out.println("ЗП в 1 отделе проиндексированы");
                                    break;
                                case 6:
                                    System.out.println("Введите значение процента индексации");
                                    percent = scanner.nextInt();
                                    listEmployer.indexationWages(1, percent);
                                    listEmployer.indexationWages(2, percent);
                                    listEmployer.indexationWages(3, percent);
                                    listEmployer.indexationWages(4, percent);
                                    listEmployer.indexationWages(5, percent);
                                    System.out.println("ЗП в 1 отделе проиндексированы");
                                    break;
                                case 7:
                                    break;
                                default:
                                    System.out.println("Неправильно выбрано действие");
                                    break;
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Неправильно выбрано действие");
                            break;
                    }
                    break;
                default:
                    System.out.println("Неправильно выбрано действие");
                    break;
            }
        }
    }
}