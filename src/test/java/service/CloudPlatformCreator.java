package service;

import model.CloudPlatformModel;

public class CloudPlatformCreator {
    private static final String NUMBER_OF_INSTANCES = "testData.cloudPlatform.instances";
    private static final String MACHINE_SERIES = "testData.cloudPlatform.machineSeries";
    private static final String MACHINE_TYPE = "testData.cloudPlatform.machineType";
    private static final String NUMBER_OF_GPU = "testData.cloudPlatform.numberOfGPU";
    private static final String GPU_TYPE = "testData.cloudPlatform.gpuType";
    private static final String LOCAL_SSD = "testData.cloudPlatform.localSSD";
    private static final String DATA_CENTRE_LOCATION = "testData.cloudPlatform.dataCentreLocation";
    private static final String COMMITTED_USAGE = "testData.cloudPlatform.committedUsage";
    private static final String MANUAL_CALCULATING_COST = "testData.cloudPlatform.manualCalculatingCost";

    public static CloudPlatformModel createCloudPlatformWithCredentialsFromProperty() {
        return new CloudPlatformModel(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(MACHINE_SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATA_CENTRE_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE),
                TestDataReader.getTestData(MANUAL_CALCULATING_COST));
    }
}
