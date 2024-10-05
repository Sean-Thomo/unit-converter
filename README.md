# Unit Converter Web Application

[PROJECT URL](https://roadmap.sh/projects/unit-converter)

## Overview

This is a simple web application built using Java and Spring Boot that allows users to convert between various units of measurement. The application supports conversions for length, weight, temperature, and more. Users can input a value, select the units to convert from and to, and view the converted value.

## Features

- User-friendly web interface.
- Supports conversions between different units of measurement:
  - **Length**: millimeter, centimeter, meter, kilometer, inch, foot, yard, mile.
  - **Weight**: milligram, gram, kilogram, ounce, pound.
  - **Temperature**: Celsius, Fahrenheit, Kelvin.
- Input field for entering the value to convert.
- Dropdown menus for selecting units to convert from and to.
- Display of the converted value.

## Requirements

- Java 11 or higher
- Maven
- Spring Boot
- Thymeleaf

## Getting Started

### Clone the Repository

```bash
git clone git@github.com:Sean-Thomo/unit-converter.git
cd unit-converter
```

### Build the Project

Navigate to the project directory and build the project using Maven:

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on http://localhost:8080.

### Accessing the Application

Open your web browser and go to http://localhost:8080 to access the unit converter web app.

### Usage

Select Measurement Type: Choose the type of measurement you want to convert (e.g., Length, Weight, Temperature).
Input Value: Enter the value you wish to convert in the input field.
Select Units: Use dropdown menus to select the units you want to convert from and to.
View Result: Click on the "Convert" button to see the converted value displayed on the page.
Example Conversions
Convert 100 centimeters to meters.
Convert 5 kilograms to pounds.
