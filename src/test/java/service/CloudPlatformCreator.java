package service;

import model.CloudPlatformModel;

public class CloudPlatformCreator
{
    private static final int NUMBER_OF_INSTANCES = 4;
    private static final String MACHINE_SERIES = "N1";
    private static final String MACHINE_TYPE = "n1-standard-8";
    private static final boolean ADD_GPU = true;
    private static final int NUMBER_OF_GPU = 1;
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String LOCAL_SSD = "2x375";
    private static final String DATA_CENTRE_LOCATION = "Frankfurt";
    private static final String COMMITTED_USAGE = "1 Year";

    public static CloudPlatformModel createCloudPlatformWithCredentialsFromProperty()
    {
        return new CloudPlatformModel(NUMBER_OF_INSTANCES, MACHINE_SERIES, MACHINE_TYPE, ADD_GPU,
                NUMBER_OF_GPU, GPU_TYPE, LOCAL_SSD, DATA_CENTRE_LOCATION, COMMITTED_USAGE);
    }
}
