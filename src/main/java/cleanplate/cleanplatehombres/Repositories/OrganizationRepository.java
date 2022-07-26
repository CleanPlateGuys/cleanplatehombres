package cleanplate.cleanplatehombres.Repositories;

import cleanplate.cleanplatehombres.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Organization getById(Integer id);
    List<Organization> getOrganizationByUser(User user);
    List<Organization> getOrganizationByUserId(Integer id);
//    Organization getOrganizationById(Integer id);
//    Organization getOrganizationAddress(String orgStAddress);
    List<Organization> getAllByOrgNameContaining(@Param("keyword") String orgName);

}