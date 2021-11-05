package service;

import model.CloudPlatformModel;

public class CloudPlatformCreator
{
    private static final String NUMBER_OF_INSTANCES = "testData.cloudPlatform.instances";
    private static final String MACHINE_SERIES = "testData.cloudPlatform.machineSeries";
    private static final String MACHINE_TYPE = "testData.cloudPlatform.machineType";
    private static final String NUMBER_OF_GPU = "testData.cloudPlatform.numberOfGPU";
    private static final String GPU_TYPE = "testData.cloudPlatform.gpuType";
    private static final String LOCAL_SSD = "testData.cloudPlatform.localSSD";
    private static final String DATA_CENTRE_LOCATION = "testData.cloudPlatform.dataCentreLocation";
    private static final String COMMITTED_USAGE = "testData.cloudPlatform.committedUsage";
    private static final String MANUAL_CALCULATING_COST = "testData.cloudPlatform.manualCalculatingCost";

    public static CloudPlatformModel createCloudPlatformWithCredentialsFromProperty()
    {
        return new CloudPlatformModel(NUMBER_OF_INSTANCES, MACHINE_SERIES, MACHINE_TYPE, NUMBER_OF_GPU,
                GPU_TYPE, LOCAL_SSD, DATA_CENTRE_LOCATION, COMMITTED_USAGE, MANUAL_CALCULATING_COST);
    }
}
