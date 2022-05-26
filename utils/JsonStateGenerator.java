public class JsonStateGenerator {

    public void generate() {
        ObjectMapper mapper = new ObjectMapper();
        State state = new State();
        state.setId("62859e39e8f3d410734a90f1");
        state.setAnnotation("initial state from a game of life experiment");
        state.setCurrentGeneration(65);
        state.setEnvironment(
                (CellularAutomaton) new EnvironmentGenerator().generateEnvironment2(32, 32));
        try {
            // Object to JSON in file
            mapper.writeValue(
                    new File("C:\\Users\\dglab\\OneDrive\\Escritorio\\jacksonTest\\state.json"),
                    state);
            // Object to JSON in String
            // String jsonInString = mapper.writeValueAsString(state);
            // System.out.println(jsonInString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
