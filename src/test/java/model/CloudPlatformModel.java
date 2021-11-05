package model;

import java.util.Objects;

public class CloudPlatformModel
{
    private int numberOfInstances;
    private String machineSeries;
    private String machineType;
    private boolean addGPU;
    private int numberOfGPU;
    private String gpuType;
    private String localSSD;
    private String dataCentreLocation;
    private String committedUsage;

    public CloudPlatformModel(int numberOfInstances, String machineSeries, String machineType,
                              boolean addGPU, int numberOfGPU, String gpuType, String localSSD,
                              String dataCentreLocation, String committedUsage)
    {
        this.numberOfInstances = numberOfInstances;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.addGPU = addGPU;
        this.numberOfGPU = numberOfGPU;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.dataCentreLocation = dataCentreLocation;
        this.committedUsage = committedUsage;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public boolean isAddGPU() {
        return addGPU;
    }

    public void setAddGPU(boolean addGPU) {
        this.addGPU = addGPU;
    }

    public int getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(int numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCentreLocation() {
        return dataCentreLocation;
    }

    public void setDataCentreLocation(String dataCentreLocation) {
        this.dataCentreLocation = dataCentreLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloudPlatformModel that = (CloudPlatformModel) o;
        return numberOfInstances == that.numberOfInstances
                && addGPU == that.addGPU
                && numberOfGPU == that.numberOfGPU
                && Objects.equals(machineSeries, that.machineSeries)
                && Objects.equals(machineType, that.machineType)
                && Objects.equals(gpuType, that.gpuType)
                && Objects.equals(localSSD, that.localSSD)
                && Objects.equals(dataCentreLocation, that.dataCentreLocation)
                && Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, machineSeries,
                machineType, addGPU, numberOfGPU, gpuType,
                localSSD, dataCentreLocation, committedUsage);
    }
}
