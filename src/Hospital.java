import java.util.Random;

public class Hospital {

    private int availableNurses;
    private int availableDoctors;
    private int availableExaminingRooms;
    private int availableReceptionists;
    private int patients;
    private RessourceProvider ressourceProvider;

    // CONSTRUCTOR
    public Hospital(RessourceProvider ressourceProvider) {
        this.availableNurses = 5;
        this.availableDoctors = 5;
        this.availableExaminingRooms = 10;
        this.availableReceptionists = 2;
        this.patients = 0;
        this.ressourceProvider = ressourceProvider;
    }

    // GETTERS
    public int getAvailableNursesNurses() {
        return this.availableNurses;
    }

    public void increaseAvailableNurse() {
        this.availableNurses++;
    }

    public void decreaseAvailableNurse() {
        this.availableNurses--;
    }

    public int getAvailableExaminingRooms() {
        return this.availableExaminingRooms;
    }

    public void increaseAvailableRooms() {
        this.availableExaminingRooms++;
    }

    public void decreaseAvailableRooms() {
        this.availableExaminingRooms--;
    }

    public int getAvailableDoctors() {
        return this.availableDoctors;
    }

    public void increaseAvailableDoctors() {
        this.availableDoctors++;
    }

    public void decreaseAvailableDoctors() {
        this.availableDoctors--;
    }

    public int getPatients() {
        return this.patients;
    }

    public void increasePatients() {
        this.patients++;
    }

    public void decreasePatients() {
        this.patients--;
    }

    // RUN THE HOSPITAL
    public void runHospital() {
        int patientCounter = 0;
        boolean start = true;
        boolean run = true;

        while (run) {

            sleep(1000);
            if (start) {
                // 2 patients arrive
                patientCounter++;
                startNewPatientTask(patientCounter);
                sleep(5000);
                patientCounter++;
                startNewPatientTask(patientCounter);
                start = false;
            }

        }
    }

    private boolean newPatientArrive() {
        int randInt = new Random().nextInt(10) + 1;
        return randInt > 6;
    }

    private void startNewPatientTask(int taskId) {
        increasePatients();
        Thread task = new Thread(new patientTask(taskId, this));
        task.start();
    }

    private void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
