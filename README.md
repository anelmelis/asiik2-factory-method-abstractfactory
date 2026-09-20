# Factory Method and Abstract Factory Logistics Application

## Project Purpose

This project is a Java console application developed to demonstrate the use of two software design patterns: Factory Method and Abstract Factory.

The application represents a simple logistics system where a user can select a delivery mode and a user interface platform.

The Factory Method pattern is used for creating different transport types. Depending on the selected delivery mode, the application creates either a Truck for road delivery or a Ship for sea delivery.

The Abstract Factory pattern is used for creating a matching family of user interface components. Depending on the selected platform, the application creates Windows or macOS buttons and checkboxes.

Both design patterns work together in one application.

---

## Technologies and Prerequisites

- Java JDK 25
- IntelliJ IDEA
- Git and GitHub repository

The project does not require:
- Database
- Web framework
- External services

---


## Project Structure

```text
src
│
├── Main.java
│
├── transport
│   ├── Transport.java
│   ├── Truck.java
│   └── Ship.java
│
├── logistics
│   ├── Logistics.java
│   ├── RoadLogistics.java
│   └── SeaLogistics.java
│
├── ui
│   ├── Button.java
│   ├── Checkbox.java
│   ├── WindowsButton.java
│   ├── WindowsCheckbox.java
│   ├── MacOSButton.java
│   ├── MacOSCheckbox.java
│   ├── GUIFactory.java
│   ├── WindowsFactory.java
│   └── MacOSFactory.java
│
└── application
└── DeliveryApplication.java
```


# Factory Method Implementation

The Factory Method pattern is responsible for creating transport objects.

## Product

The `Transport` interface defines the common delivery behavior:
```
deliver(String cargo, String destination)
```
## Concrete Products

The application contains two transport implementations:

- `Truck` - provides road delivery behavior.
- `Ship` - provides sea delivery behavior.

## Creator

The abstract class `Logistics` works as the creator.

It contains:

```
createTransport()
```
which is overridden by concrete creators.

The class also contains:
```
planDelivery()
```
which provides the common delivery workflow.

## Concrete Creators

Two concrete creator classes are implemented:

- `RoadLogistics` creates a `Truck` object.
- `SeaLogistics` creates a `Ship` object.

The client does not directly create transport objects. Transport creation is handled through the Factory Method.

---

# Abstract Factory Implementation

The Abstract Factory pattern is responsible for creating related UI components.

## Abstract Products

Two product interfaces are used:

- `Button`
- `Checkbox`

Both interfaces define a rendering method:
```
paint()
```

## Concrete Products

Windows family:

- `WindowsButton`
- `WindowsCheckbox`

macOS family:

- `MacOSButton`
- `MacOSCheckbox`

Each component prints its platform and component type during rendering.

## Abstract Factory

The `GUIFactory` interface defines methods:

```
createButton()
createCheckbox()
```

## Concrete Factories

Two factories are implemented:

- `WindowsFactory`
- `MacOSFactory`

Each factory creates a matching pair of UI components for its platform.

---

# Application Integration

The `DeliveryApplication` class combines both design patterns.

It receives:

- `GUIFactory`
- `Logistics`

through its constructor.

The application obtains UI components from the selected GUI factory and starts the delivery process using the selected logistics creator.

The client works with interfaces instead of concrete classes.

---

# How to Build and Run

## Step 1

Clone the repository:
```
git clone <repository-link>
```

## Step 2

Open the project in IntelliJ IDEA.

## Step 3

Select Java JDK 25.

## Step 4

Build the project:

Build → Build Project
or use:
```
Ctrl + F9
```

## Step 5

Run:

```
Main.java
```

---

# Supported Input Values

## Delivery Mode

The application accepts:

ROAD
SEA
Available options:

- ROAD creates `RoadLogistics` with `Truck`.
- SEA creates `SeaLogistics` with `Ship`.

---

## UI Platform

The application accepts:
```
WINDOWS
MACOS
```

Available options:

- WINDOWS creates Windows button and Windows checkbox.
- MACOS creates macOS button and macOS checkbox.

---

# Sample Run 1

Input:
```
ROAD
WINDOWS
```

Output:
```
Delivery mode: ROAD
UI platform: WINDOWS

Rendering Windows button
Rendering Windows checkbox

Delivery planning started
Truck delivers laboratory equipment to Aktau warehouse
```

---

# Sample Run 2

Input:
```
SEA
MACOS
```

Output:
```
Delivery mode: SEA
UI platform: MACOS

Rendering macOS button
Rendering macOS checkbox

Delivery planning started
Ship delivers laboratory equipment to Aktau warehouse
```

---

# Validation

The application validates user input.

## Unsupported delivery mode

Input:
```
AIR
WINDOWS
```

Output:
```
Unsupported delivery mode
```

The application stops without creating a transport object.

---

## Unsupported UI platform

Input:
```
ROAD
LINUX
```

Output:
```
Unsupported UI platform
```

The application stops without creating UI components.

---

# Design Decisions

Factory Method was selected for transport creation because the application can add new delivery types without changing the main delivery workflow.

Abstract Factory was selected for UI components because it guarantees that related components from the same platform are created together.

The combination of both patterns allows the application to change the transport type and UI family independently.