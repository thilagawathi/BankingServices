/**
 * {@link OffsetLimitRequest}
 */
package com.bank.service.page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class OffsetLimitRequest implements Pageable {

	private Integer limit;
	private Integer offset;



	public OffsetLimitRequest(Integer limit, Integer offset) {
		this.limit = limit;
		this.offset = offset;
	}

	@Override
	public int getPageNumber() {
		return 1;
	}

	@Override
	public int getPageSize() {
		return this.limit;
	}

	@Override
	public long getOffset() {
		return this.offset;
	}

	@Override
	public Pageable first() {
		return null;
	}

	@Override
	public Pageable next() {

		return null;
	}

	@Override
	public Pageable previousOrFirst() {

		return null;
	}

	@Override
	public boolean hasPrevious() {

		return false;
	}

	@Override
	public Pageable withPage(int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}
}
