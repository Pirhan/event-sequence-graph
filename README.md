## What is an event sequence graph?
An Event Sequence Graph (ESG) is a simple albeit powerful formalism for capturing the behavior of a variety of
interactive systems that include real-time, embedded systems, and graphical user interfaces. A collection of ESGs is
proposed as a model of an interactive system. This collection is used for the generation of tests to check for the
correctness of system behavior in the presence of expected and unexpected input event sequences.

Please refer to [here](https://www.researchgate.net/figure/An-event-sequence-graph_fig1_249675960) for more information.

## About The Project
Generates an **event sequence graph** that represents the given set of connections between nodes at the **k**th level.
**k** represents how many components of an event should be present at one of the nodes. (AKA how deep the event 
sequence graph is)

Please refer to [explanation_1](docs/explanation_1.jpg) and [explanation_2](docs/explanation_2.jpg) under the **docs**
folder for a more thorough explanation of what we are dealing with.

## Example Case
For example, if the input parameters are as follows:<br/>
<img src="https://user-images.githubusercontent.com/64742446/139163619-d418bb36-0cb1-4e49-a08e-0baefc4eac27.png" alt="inputs" width="300" />

In the first level we will have the following connections and nodes;<br/>
<img src="https://user-images.githubusercontent.com/64742446/139161704-876941d8-802e-45c0-9d02-bd122f6c7e93.png" alt="level_1" width="300" />

In the second level, some connections and nodes will look like;<br/>
<img src="https://user-images.githubusercontent.com/64742446/139162011-7369594d-60e2-4dc9-9c87-f9f7368a3784.png" alt="level_2" width="300" />

In the third level, some connections and nodes will look like;<br/>
<img src="https://user-images.githubusercontent.com/64742446/139164266-e4b110e5-0a47-436f-b57f-e0e22ee59f5e.png" alt="level_3" width="300" />

So on and so forth...

## Playing With Examples
All you need to do in order to get involved with the examples is:
- Clone the repository (`git clone https://github.com/Pirhan/event-sequence-graph.git`)
- Change or add your own examples under `src/examples`
  - Change the input parameters inside `Main.java`
    - How deep the event sequence graph should be can be changed from the parameter **level**
    - Path to the examples can be changed by **filePath** given to the reader
- Run the program!

## Contributing
Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
Distributed under the MIT License. See [`LICENSE`](LICENSE) for more information.
