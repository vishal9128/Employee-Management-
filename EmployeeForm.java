package dao;

import Beans.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeForm extends JFrame {
    private JTextField txtFirstName, txtLastName, txtEmail, txtId, txtSalary, txtDepartment, txtPosition, txtLocation;
    private JButton btnAdd, btnUpdate, btnDelete, btnViewAll;
    private JTextArea resultArea;
    private EmployeeDao employeeDao;

    public EmployeeForm() {
        employeeDao = new EmployeeDao();

        // UI Components
        setLocation(500, 200);
        setLayout(new GridLayout(12, 2));

        JLabel lblId = new JLabel("Employee ID:");
        txtId = new JTextField();
        add(lblId);
        add(txtId);

        JLabel lblFirstName = new JLabel("FUll Name:");
        txtFirstName = new JTextField();
        add(lblFirstName);
        add(txtFirstName);

//        JLabel lblLastName = new JLabel("Last Name:");
//        txtLastName = new JTextField();
//        add(lblLastName);
//        add(txtLastName);

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        add(lblEmail);
        add(txtEmail);

        JLabel lblSalary = new JLabel("Salary:");
        txtSalary = new JTextField();
        add(lblSalary);
        add(txtSalary);

        JLabel lblDepartment = new JLabel("Department:");
        txtDepartment = new JTextField();
        add(lblDepartment);
        add(txtDepartment);

        JLabel lblPosition = new JLabel("Job Position:");
        txtPosition = new JTextField();
        add(lblPosition);
        add(txtPosition);

        JLabel lblLocation = new JLabel("Location:");
        txtLocation = new JTextField();
        add(lblLocation);
        add(txtLocation);

        btnAdd = new JButton("Add Employee");
        btnUpdate = new JButton("Update Employee");
        btnDelete = new JButton("Delete Employee");
        btnViewAll = new JButton("View All Employees");

        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnViewAll);

        resultArea = new JTextArea(10, 30);
        add(new JScrollPane(resultArea));

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        btnViewAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllEmployees();
            }
        });

        setTitle("Employee Management");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addEmployee() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String fullName = txtFirstName.getText();
//            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            int salary = Integer.parseInt(txtSalary.getText());
            String department = txtDepartment.getText();
            String jobPosition = txtPosition.getText();
            String location = txtLocation.getText();

            Employee newEmployee = new Employee(id, fullName, email, salary, department, jobPosition, location);
            employeeDao.saveEmployee(newEmployee);
            resultArea.setText("Employee added successfully!");
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid input. Please check the Employee ID and Salary format.");
        }
        clearFields();
    }

    private void updateEmployee() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Employee employee = employeeDao.getEmployee(id);
            if (employee != null) {
                employee.setFullName(txtFirstName.getText());
//                employee.setLastName(txtLastName.getText());
                employee.setEmail(txtEmail.getText());
                employee.setSalary(Integer.parseInt(txtSalary.getText()));
                employee.setDepartment(txtDepartment.getText());
                employee.setJobPosition(txtPosition.getText());
                employee.setLocation(txtLocation.getText());

                employeeDao.updateEmployee(employee);
                resultArea.setText("Employee updated successfully!");
            } else {
                resultArea.setText("Employee not found.");
            }
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid input. Please check the Employee ID and Salary format.");
        }
        clearFields();
    }

    private void deleteEmployee() {
        try {
            int id = Integer.parseInt(txtId.getText());
            employeeDao.deleteEmployee(id);
            resultArea.setText("Employee deleted successfully!");
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid ID format. Please enter a valid integer for the Employee ID.");
        }
        clearFields();
    }

    private void viewAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        StringBuilder sb = new StringBuilder();
        for (Employee emp : employees) {
            sb.append(emp.getId()).append(" | ")
                    .append(emp.getFullName()).append(" ")
//                    .append(emp.getLastName()).append(" | ")
                    .append(emp.getEmail()).append(" | ")
                    .append(emp.getSalary()).append(" | ")
                    .append(emp.getDepartment()).append(" | ")
                    .append(emp.getJobPosition()).append(" | ")
                    .append(emp.getLocation()).append("\n");
        }
        resultArea.setText(sb.toString());
    }

    private void clearFields() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtSalary.setText("");
        txtDepartment.setText("");
        txtPosition.setText("");
        txtLocation.setText("");
        txtId.setText("");
    }

    public static void main(String[] args) {
        new EmployeeForm();
    }
}
