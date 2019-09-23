package com.gkarthiks.k8s;
import java.io.IOException;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.Config;
public class ListPod {
    public static void main(String[] args) throws IOException, ApiException{
    	ApiClient client = Config.fromUserPassword("<k8s cluster url>", "<uname>", "<password>", false);
        System.out.println(client.getBasePath()+"\n\n");
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();
        V1PodList list = api.listNamespacedPod("default", null, null, null, null, null, null, null, null, null);
        //listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1Pod item : list.getItems()) {
            System.out.println("Pod Name: "+item.getMetadata().getName());
        }
    }
}