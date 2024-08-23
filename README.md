
# Cache Simulator

## Overview

This project is a Cache Simulator that allows users to simulate the behavior of different cache mapping techniques. The simulator provides a graphical user interface (GUI) for users to enter memory addresses and observe how they are stored or accessed in the cache. It supports three types of cache mapping:
- **Direct Mapped**
- **Fully Associative**
- **Set Associative**

The simulator also visualizes the state of the cache, showing hits and misses for each memory access.

### Features

- **Supports Multiple Cache Mapping Techniques**: Direct Mapped, Fully Associative, and Set Associative caches.
- **Visual Representation of Cache State**: The GUI displays the cache's tags and contents, updated with each memory access.
- **Memory Access Feedback**: Alerts the user if there is a cache hit, cache miss, or memory access violation (e.g., segmentation fault).

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that JDK is installed on your system. The code is written in Java, so you'll need the JDK to compile and run it.

- **Input Parameters**: The simulator will prompt you for the following:
   - Main Memory size (in bytes)
   - Cache size (in bytes)
   - Block size (in bytes)
   - Cache Mapping Type (Direct Mapped, Fully Associative, Set Associative)
   - Set size (if Set Associative mapping is chosen)

- **Simulate Cache Access**: Enter memory addresses in the GUI to observe how the cache handles them. The simulator will indicate whether the access resulted in a cache hit or miss and will update the cache display accordingly.

## Cache Mapping Techniques

- **Direct Mapped**: Each memory block maps to exactly one cache line. Simple and fast but prone to conflicts.
- **Fully Associative**: Any memory block can be placed in any cache line. Offers maximum flexibility but requires complex searching.
- **Set Associative**: A compromise between Direct Mapped and Fully Associative. Each block can be placed in a limited number of cache lines (a set).

## File Structure

- `CacheSimulator.java`: The main file that contains all classes and methods necessary for running the simulator.
  - **Cache Interface**: Defines the `accessMemory` method to be implemented by different cache types.
  - **FullyAssociativeCache**: Implements a fully associative cache.
  - **DirectMappedCache**: Implements a direct mapped cache.
  - **SetAssociativeCache**: Implements a set associative cache.
  - **CachePanel**: Handles the GUI representation of the cache.
  - **CacheSimulator**: The main class that initializes the GUI and cache based on user inputs.

## Contributing

Contributions are welcome! Feel free to fork the repository, make improvements, and submit pull requests.

## Acknowledgements

This project was developed as part of an educational exercise to demonstrate cache memory concepts in computer architecture.
