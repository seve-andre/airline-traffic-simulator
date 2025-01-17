<img align="left" src="https://github.com/seve-andre/airline-traffic-simulator/blob/main/src/main/resources/images/logos/logo.png?raw=true" alt="Airline Traffic Simulator logo" title="Airline Traffic Simulator logo" />
<p align="right">
    <a href="https://github.com/seve-andre/airline-traffic-simulator/blob/main/README_ITA.md"><strong>Italian version »</strong></a>
</p>
<br />

# AirLine Traffic Simulator
AirLine Traffic Simulator is a videogame inspired by [Flight Control](https://www.youtube.com/watch?v=KTH084KeFBc)
for AirLine traffic management. User goal is to **land as many airplanes as possible** without any collisions (cause game ending). 
Airplanes spawn into the map progressively. **User is in charge of airplanes movement**, mouse drawing their routes. Game difficulty 
increases with increasing number of airplanes landed.

## Mandatory features
- Correct airplane-route mouse drawing
- Implementation of A.I. algorithm to move airplanes when user is not drawing (once the airplane is in the map, it can't get out)
- Efficient airplane management when entering the map and landing on airstrip
- File management for names and scores
- Increasing difficulty throughout the game

## Optional features
- Creation and addition of dynamic maps (i.e. dynamic animations, objects causing explosion when flown over)
- Game sound implementation
- New airplanes with different speed
- Wind management: causing increasing or decreasing airplane speed

### Challenges
- Animations fluency (route drawing, airplanes movement and landing, collisions)
- MVC Pattern correct implementation
- Increasing difficulty throughout the game 

### Delegation of tasks
- **Rodilosso**
    - Airplane movements
    - Airplane A.I. route implementation
    - Animations
- **Severi**
    - UI and UX
    - Airplane indicators when entering the map
    - File management (saving, loading, displaying)
    - Pause Menu Threads Management throughout the game
- **Foschi**
    - Landing Airstrip and Airplane landing
    - Points deployment
    - Airplanes collisions
