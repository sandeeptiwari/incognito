package com.solvathon.incognito.service;

import com.solvathon.incognito.model.entity.Policy;
import org.springframework.stereotype.Service;


@Service
public class BuyPolicyService {

    private final PolicyService policyService;
    private final QuoteService quoteService;

    public BuyPolicyService(PolicyService policyService, QuoteService quoteService) {
        this.policyService = policyService;
        this.quoteService = quoteService;
    }


    public String buyPolicy(int userId, int policyId) {


        /*Policy quote = quoteService.getQuoteMap().get(policyId);
        Policy policyPurchased = new Policy(policyId, quote.getPremium(), quote.getFees(),
                quote.getEffectiveDate(), quote.getPolicyExpirationDate(), quote.getPolicyYear(),
                quote.getInsuranceType(), quote.getStatus(), userId, quote.getPolicyId());

        policyService.getPolicyMap().put(policyService.getPolicyMap().size() + 1, policyPurchased);
*/
        return "Policy successfully purchased";
    }

}
