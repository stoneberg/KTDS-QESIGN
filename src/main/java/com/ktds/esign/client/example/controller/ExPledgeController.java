package com.ktds.esign.client.example.controller;

import com.ktds.esign.client.example.payload.ExUserPledgeReq.CreateDto;
import com.ktds.esign.client.example.payload.ExUserPledgeReq.SearchDto;
import com.ktds.esign.client.example.payload.ExUserPledgeReq.UpdateDto;
import com.ktds.esign.client.example.payload.ExUserPledgeRes.FindDto;
import com.ktds.esign.client.example.service.ExPledgeService;
import com.ktds.esign.code.service.CodeService;
import com.ktds.esign.common.exception.ResourceNotFoundException;
import com.ktds.esign.common.response.ResponseDto;
import com.ktds.esign.common.utils.PaginationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("example")
public class ExPledgeController {

    private final ExPledgeService exPledgeService;
    private final CodeService codeService;
    private final PaginationUtil paginationUtil;

    /**
     * create page
     * @param mav
     * @return
     */
    @GetMapping("user/pledge/view")
    public ModelAndView pledge(ModelAndView mav) {
        mav.setViewName("views/example/user-pledge");
        mav.addObject("commonCode", codeService.findAllCodeList());
        return mav;
    }


    @PostMapping("user/pledge")
    public ResponseDto<?> createUserPledge(@RequestBody CreateDto createDto) {
        return ResponseDto.of(exPledgeService.createUserPledge(createDto));
    }


    /**
     * list page
     * @param mav
     * @return
     */
    @GetMapping("user/pledges/view")
    public ModelAndView list(ModelAndView mav) {
        mav.setViewName("views/example/user-pledge-list");
        mav.addObject("commonCode", codeService.findAllCodeList());
        return mav;
    }

    @GetMapping("user/pledges/count")
    public ResponseDto<?> getUserPledgeResultCount(SearchDto searchDto) {
        return ResponseDto.of(exPledgeService.findUserPledgeResultCount(searchDto));
    }

    /**
     * Get Parameter Mapping Enum Domain convert 작동안함
     * Post @RequestBody Mapping 시에만 작동함
     *
     * @param searchDto
     * @param pageable
     * @return
     */
    @GetMapping("user/pledges/list")
    public ResponseDto<?> getUserPledgeList(SearchDto searchDto, Pageable pageable) {
        Page<FindDto> page = exPledgeService.findUserPledgeList(searchDto, pageable);
        String paginationHtml = paginationUtil.getPagination(page);
        return ResponseDto.of(page, paginationHtml);
    }

    /**
     * detail page
     * @param userPledgeId
     * @param mav
     * @return
     */
    @GetMapping("user/pledges/detail/view")
    public ModelAndView detail(@RequestParam String userPledgeId, ModelAndView mav) {
        mav.setViewName("views/example/user-pledge-detail");
        mav.addObject("userPledgeId", userPledgeId);
        mav.addObject("commonCode", codeService.findAllCodeList());
        return mav;
    }

    @GetMapping("user/pledges/detail/{id}")
    public ResponseDto<?> getUserPledgeDetail(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseDto.of(exPledgeService.findUserPledgeDetail(id));
    }

    @PutMapping("user/pledges/detail/{id}")
    public ResponseDto<?> updateUserPledgeDetail(@PathVariable Long id, @RequestBody UpdateDto updateDto) throws ResourceNotFoundException {
        return ResponseDto.of(exPledgeService.updateUserPledge(id, updateDto));
    }

    @DeleteMapping("user/pledges/detail/{id}")
    public ResponseDto<?> deletePledgeDetail(@PathVariable Long id) throws ResourceNotFoundException {
        exPledgeService.deleteUserPledge(id);
        return ResponseDto.ok();
    }

}
