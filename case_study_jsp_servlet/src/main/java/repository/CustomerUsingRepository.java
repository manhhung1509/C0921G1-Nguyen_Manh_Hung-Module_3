package repository;

import bean.ContractDetail;

import java.util.List;

public interface CustomerUsingRepository {
    public List<ContractDetail> selectAll();
}
