package com.nationwide.nf.rp.controller;

import com.nationwide.nf.rp.bean.*;
import com.nationwide.nf.rp.service.LoanService;
import com.nationwide.nf.rp.bean.AspectMiningResult;
import com.nationwide.nf.rp.util.LoanWebServiceValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by John Jorgensen on 4/17/2017.
 */
@Controller
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    LoanWebServiceValidator validator;

    private Logger log = Logger.getLogger(getClass().getName());

    @RequestMapping(method = RequestMethod.PUT, value = "/loan/updateAspectMine", produces =  {"application/json"})
    public ResponseEntity<AspectMiningResult> updateAspectMine(@RequestBody AspectMine aspectMine) {

        log.debug("Calling updateAspectMine with parameters, AspectMine: '" + aspectMine);

        if (validator.isValidAspectMineInputParameters(aspectMine)) {
            AspectMiningResult aspectMineResult =
                    loanService.updateAspectMine(aspectMine);

            if (aspectMineResult == null) {
                return new ResponseEntity<AspectMiningResult>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<AspectMiningResult>(aspectMineResult, HttpStatus.OK);

        } else {
            return new ResponseEntity<AspectMiningResult>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loan/{loanNumber}", produces =  {"application/json"})
    public ResponseEntity<LoanDetail> getPrincipalAndInterest(@PathVariable String loanNumber,
                                                              @RequestParam("repayAmount") String repayAmount,
                                                              @RequestParam("repayDate") String repayDate) {

        log.debug("Calling getPrincipalAndInterest with parameters: Loan Number '" +
                loanNumber + "', Repay Amount '" + repayAmount + "', Repay Date '" + repayDate + "'");

        if (validator.isValidGetPrincipalAndInterestInputParameters(loanNumber, repayAmount, repayDate)) {
            LoanDetail loanDetail = loanService.getPrincipalAndInterest(validator.getNumber(loanNumber),
                    validator.getAmount(repayAmount), validator.getDate(repayDate));
            if (loanDetail == null) {
                return new ResponseEntity<LoanDetail>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<LoanDetail>(loanDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<LoanDetail>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/loan/{loanNumber}/repayment", produces =  {"application/json"})
    public ResponseEntity<LoanCorrectionDetail> updateRepayment(@PathVariable String loanNumber,
                                                                @RequestBody RepaymentDetail repaymentDetail) {

        log.debug("Calling updateRepayment with parameters: Loan Number '" + loanNumber +
                "', Repayment Detail '" + repaymentDetail);

        if (validator.isValidRepaymentInputParameters(loanNumber, repaymentDetail)) {
            LoanCorrectionDetail loanCorrectionDetail = loanService.processRepayment(validator.getNumber(loanNumber), repaymentDetail);
            if (loanCorrectionDetail == null) {
                return new ResponseEntity<LoanCorrectionDetail>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<LoanCorrectionDetail>(loanCorrectionDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<LoanCorrectionDetail>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/loan/{loanNumber}/reverseRepayment", produces =  {"application/json"})
    public ResponseEntity<LoanCorrectionDetail> updateReverseRepayment(@PathVariable String loanNumber,
                                                                       @RequestBody ReverseRepaymentDetail reverseRepaymentDetail) {

        log.debug("Calling updateReverseRepayment with parameters, Loan Number: '" + loanNumber +
                "', Reverse Repayment Request: " + reverseRepaymentDetail);

        if (validator.isValidUpdateReverseRepaymentInputParameters(loanNumber, reverseRepaymentDetail)) {
            LoanCorrectionDetail loanCorrectionDetail =
                    loanService.reverseRepayment(validator.getNumber(loanNumber), reverseRepaymentDetail);

            if (loanCorrectionDetail == null) {
                return new ResponseEntity<LoanCorrectionDetail>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<LoanCorrectionDetail>(loanCorrectionDetail, HttpStatus.OK);

        } else {
            return new ResponseEntity<LoanCorrectionDetail>(HttpStatus.BAD_REQUEST);
        }
    }
}
