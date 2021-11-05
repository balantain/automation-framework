package model;

import java.util.Objects;

public class CloudPlatformModel
{
    private String numberOfInstances;
    private String machineSeries;
    private String machineType;
    private String numberOfGPU;
    private String gpuType;
    private String localSSD;
    private String dataCentreLocation;
    private String committedUsage;
    private String manualCalculatingCost;

    public CloudPlatformModel(String numberOfInstances, String machineSeries, String machineType,
                              String numberOfGPU, String gpuType, String localSSD,
                              String dataCentreLocation, String committedUsage, String manualCalculatingCost)
    {
        this.numberOfInstances = numberOfInstances;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.numberOfGPU = numberOfGPU;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.dataCentreLocation = dataCentreLocation;
        this.committedUsage = committedUsage;
        this.manualCalculatingCost = manualCalculatingCost;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
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

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
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

    public String getManualCalculatingCost() {
        return manualCalculatingCost;
    }

    public void setManualCalculatingCost(String manualCalculatingCost) {
        this.manualCalculatingCost = manualCalculatingCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloudPlatformModel that = (CloudPlatformModel) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances)
                && Objects.equals(machineSeries, that.machineSeries)
                && Objects.equals(machineType, that.machineType)
                && Objects.equals(numberOfGPU, that.numberOfGPU)
                && Objects.equals(gpuType, that.gpuType)
                && Objects.equals(localSSD, that.localSSD)
                && Objects.equals(dataCentreLocation, that.dataCentreLocation)
                && Objects.equals(committedUsage, that.committedUsage)
                && Objects.equals(manualCalculatingCost, that.manualCalculatingCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, machineSeries, machineType, numberOfGPU, gpuType,
                localSSD, dataCentreLocation, committedUsage, manualCalculatingCost);
    }
}
